package com.microservicesintro.currencyconversionservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyConversionController {
	private static final Logger LOGGER  = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-conversion/from/{fromCurrency}/to/{toCurrency}/amount/{amount}/")
	public CurrencyConversionBean retrievedConvertedCurrency(@PathVariable String fromCurrency, 
			@PathVariable String toCurrency, @PathVariable BigDecimal amount) {
		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(fromCurrency, toCurrency, amount, BigDecimal.valueOf(65), BigDecimal.valueOf(1000));	
		currencyConversionBean.setId(1001);
		LOGGER.info("extracted port: " + environment.getProperty("local.server.port"));
		currencyConversionBean.setPort(Integer.valueOf(environment.getProperty("server.local.port")));
		return currencyConversionBean;
	}
}
