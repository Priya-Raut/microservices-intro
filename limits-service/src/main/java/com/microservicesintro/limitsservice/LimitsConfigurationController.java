package com.microservicesintro.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsConfiguration() {
		return new LimitsConfiguration(config.getMinConfig(), config.getMaxConfig());
	}
}
