package com.microservicesintro.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<Exchange, Long>{
	Exchange findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}