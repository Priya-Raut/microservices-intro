package com.microservicesintro.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Configuration {
	private int minConfig;
	private int maxConfig;
	
	public int getMinConfig() {
		return minConfig;
	}
	public void setMinConfig(int minConfig) {
		this.minConfig = minConfig;
	}
	public int getMaxConfig() {
		return maxConfig;
	}
	public void setMaxConfig(int maxConfig) {
		this.maxConfig = maxConfig;
	}
	
	
}
