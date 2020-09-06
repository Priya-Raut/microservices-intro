package com.microservicesintro.limitsservice;

public class LimitsConfiguration {
	private int minConfig;
	private int maxConfig;
	
	public LimitsConfiguration(int minConfig, int maxConfig) {
		super();
		this.minConfig = minConfig;
		this.maxConfig = maxConfig;
	}
	
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
