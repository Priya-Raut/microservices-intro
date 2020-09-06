package com.microservicesintro.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservicesintro.entity.Exchange;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}/")
	public Exchange retrieveExchangeValue(@PathVariable String fromCurrency, 
			@PathVariable String toCurrency) {
		Exchange exchangeValue = new Exchange("USD", "INR", BigDecimal.valueOf(65.0));
		exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
