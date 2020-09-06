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

### 1. Steps for Configuration Management (using Spring Cloud Config Server)
1. Create a component for Spring Cloud Config Server. Add config server dependency. Use @EnableConfigServer annotation.
2. Create a git repository for storing configurations. Create different config files for different environments/profiles e.g dev, qa, uat etc.
Note: make sure config files are committed.
3. Give repo path in config server's application.properties file.
4. Create a component for a microservice which reads configuration. Rename application.properties to bootstrap.properties.
Give url of config server and mention active profile. (By default reads config from default profile.)
