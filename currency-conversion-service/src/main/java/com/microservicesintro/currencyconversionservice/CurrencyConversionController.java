package com.microservicesintro.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CurrencyConversionController {
	private static final Logger LOGGER  = LoggerFactory.getLogger(CurrencyConversionController.class);
	private static final String EXCHANGE_SERVICE_URL = "http://localhost:8000/currency-exchange/from/{fromCurrency}/to/{toCurrency}/";
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	@GetMapping("/currency-conversion/from/{fromCurrency}/to/{toCurrency}/amount/{amount}/")
	public CurrencyConversionBean retrievedConvertedCurrency(@PathVariable String fromCurrency, 
			@PathVariable String toCurrency, @PathVariable BigDecimal amount) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("fromCurrency", fromCurrency);
		uriVariables.put("toCurrency", toCurrency);
		
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate()
				.getForEntity(EXCHANGE_SERVICE_URL, CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean response = responseEntity.getBody();
		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(fromCurrency, toCurrency, amount, response.getConversionMultiple(), amount.multiply(response.getConversionMultiple()));	
		currencyConversionBean.setPort(response.getPort());
		return currencyConversionBean;
	}
	
	@GetMapping("/currency-conversion-feign/from/{fromCurrency}/to/{toCurrency}/amount/{amount}/")
	public CurrencyConversionBean retrievedConvertedCurrencyUsingFeign(@PathVariable String fromCurrency, 
			@PathVariable String toCurrency, @PathVariable BigDecimal amount) {
		CurrencyConversionBean response = currencyExchangeProxy.retrieveExchangeValue(fromCurrency, toCurrency);
		response.setAmount(amount);
		response.setConvertedAmount(amount.multiply(response.getConversionMultiple()));
		return response;
	}
	
	
}
