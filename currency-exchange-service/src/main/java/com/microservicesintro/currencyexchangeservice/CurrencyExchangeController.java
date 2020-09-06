package com.microservicesintro.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}/")
	public Exchange retrieveExchangeValue(@PathVariable String fromCurrency, 
			@PathVariable String toCurrency) {
		LOGGER.debug("fromCurrency: " + fromCurrency + " toCurrency: " + toCurrency);
		Exchange exchangeValue = currencyExchangeService.findExchangeValueForCurrencies(fromCurrency, toCurrency);
		exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
