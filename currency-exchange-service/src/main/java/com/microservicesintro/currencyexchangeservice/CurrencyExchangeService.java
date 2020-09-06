package com.microservicesintro.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	public Exchange findExchangeValueForCurrencies(String fromCurrency, String toCurrency) {
		return exchangeValueRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
	}
}
