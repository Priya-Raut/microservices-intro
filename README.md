# microservices-intro
This project is an attempt to get familiarise with the world of microservices. 
This project explores different components of Spring Cloud along the way.


## What are microservices?

1. They are RESTful web services
2. They are independently deployable units
3. They can be cloud enabled

## Advantages of microservices

1. Enables smaller release cycles
2. Enables leaveraging new technologies and processes
3. Enables dynamic scaling

## Challenges involved with microservices

1. Configuration management
2. Dynamic scaling, load balancing
3. Visibility

### Steps for Configuration Management (using Spring Cloud Config Server)
1. Create a component for Spring Cloud Config Server. Add config server dependency. Use @EnableConfigServer annotation.
2. Create a git repository for storing configurations. Create different config files for different environments/profiles e.g dev, qa, uat etc.
Note: make sure config files are committed.
3. Give repo path in config server's application.properties file.
4. Create a component for a microservice which reads configuration. Rename application.properties to bootstrap.properties.
Give url of config server and mention active profile. (By default reads config from default profile.)

Disadvantage:
Need to hit http://<server:port>/actuator/refresh to reflect changes in git repo in the service. This needs to be done for all the instances of the service. Quite cumbersome! 
(Need to enable it in application.properties of service)

Solution:
Use of Cloud Bus. 
1. Add dependency in spring cloud config server and the service acting as config client. 
2. Enable it in bootstrap.properties file of the service.
Just hit http://<server:port>/actuator/bus-refresh and all the instances of the service will see the latest config from the repo.

### Calling one microservice from another

1. Using RestTemplate - Needs to write unnecessary code
2. Using Feign - Define a proxy interface with different methods from the service to be called 
         - Add dependency in pom.xml
	 - Define @EnableFeignClients on application class
	 - Define proxy interface with @FeignClient, give name and url of the service to be called
Disadvantage: We have hardcode the url and in that port the service is running on
Way to overcome it: Use Client Side load balancing using Ribbon


### Steps for using Client Side Load Balancing using Ribbon
1. Add dependency spring-cloud-starter-netflix-ribbon in pom.xml
2. Add @RibbonClient annotation to proxy interface of the service to be called
3. Remove url of the service from @FeignClient annotation
4. Give urls with ports in application.properties

Disadvantage: 

We are writing urls in code in application.properties. Thus we will have to write the url everytime we have more or less instances of the service to be called.

Ways to improve: 

Register the instance with a Naming Server. (a.k.a Service Registration)
Ask Ribbon to fetch url of the service instances from the naming server. (a.k.a Service Discovery)

### Steps for using Eureka Naming Server for service registration and service discovery
1. Create a component
2. Configure services with naming server
3. Configure Ribbon to find information about existing instances of the services

How to configure service with Naming Server?

1. Use @EnableDiscoveryClient to annotate application class
2. Give url of the naming server in the application.properties file. 
       Use eureka.client.service-url.default-zone property.

How to configure Ribbon to talk to Naming Server?

1. Remove hard coded url of service to be called from application.properties
  2. Ribbon will find the service instance in Naming Server
Thus, dynamic scaling up or scaline down of service instances is possible using Namine Server, as we do not hard code service urls anywhere in the applicaion.


### API Gateway

An entrypoint or a gateway for microservices/APIs/Webservice.
Microservices do not communicate with each other directly instead communicate via a gateway.
Thus, gateway is an ideal place to implement following common functionalities
* Authentication, authorization, security
* rating limiting, throttling
* fault tolerance (if a service is down, gateway can be configured to give a default response)
* monitoring
* logging
* analytics

How to configure API Gateway to be called in between two services?
1. Configure proxy interface to talk to API Gateway using Feign Client (@FeignClient("api-gateway"). API Gateway talks to the service via @RibbonClient(service-name).
2. Call the service using http://localhost:api-gateway-port/service-name/rest-of-the-path 

### Steps for using distributed tracing using Spring Cloud Sleuth and Zipkin
Spring Cloud Sleuth : Adds a trace id to the request as it goes through API Gateway and across multiple microservices. This trace id is visible in the logs.

Disadvantage: 

It is cumbersome to find the logs having same trace id.

Solution: 

With a log aggregation mechanism and a UI where all the logs from all the microservices are visible. 

Here's how the entire solution looks like:
All microservices -> RabbitMQ -> Zipkin Distributed Tracing Server -> Database

0. Install Zipkin and RabbitMQ.
1. Make all the microservices put the log into RabbitMQ (Set dependencies for Sleuth->RabbitMQ->Zipkin)
2. Connect RabbitMQ with Zipkin (RABBITMQ_URI=amqp://localhost java -jar zipkin.jar)

### Steps to use Fault tolerance using Hystrix
1. Add depenency in pom.xml
2. Add @EnableHystrix to Application class
3. Add @HystrixCommand to the endpoint under consideration. Mention a default method to be called.
