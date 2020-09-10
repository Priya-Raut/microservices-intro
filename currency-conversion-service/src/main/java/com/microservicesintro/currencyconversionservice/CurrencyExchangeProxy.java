package com.microservicesintro.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}/")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String fromCurrency, 
			@PathVariable String toCurrency);
}
