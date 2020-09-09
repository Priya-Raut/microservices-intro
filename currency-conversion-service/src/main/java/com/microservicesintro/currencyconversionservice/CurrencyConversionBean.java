package com.microservicesintro.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {
		private long id;
		private String fromCurrency;
		private String toCurrency;
		private BigDecimal amount;
		private BigDecimal conversionMultiple;
		private BigDecimal convertedAmount;
		private int port;
		protected CurrencyConversionBean() {
			
		}
		public CurrencyConversionBean(String fromCurrency, String toCurrency, BigDecimal amount,
				BigDecimal conversionMultiple, BigDecimal convertedAmount) {
			super();
			this.fromCurrency = fromCurrency;
			this.toCurrency = toCurrency;
			this.amount = amount;
			this.conversionMultiple = conversionMultiple;
			this.convertedAmount = convertedAmount;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getFromCurrency() {
			return fromCurrency;
		}
		public void setFromCurrency(String fromCurrency) {
			this.fromCurrency = fromCurrency;
		}
		public String getToCurrency() {
			return toCurrency;
		}
		public void setToCurrency(String toCurrency) {
			this.toCurrency = toCurrency;
		}
		public BigDecimal getAmount() {
			return amount;
		}
		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}
		public BigDecimal getConversionMultiple() {
			return conversionMultiple;
		}
		public void setConversionMultiple(BigDecimal conversionMultiple) {
			this.conversionMultiple = conversionMultiple;
		}
		public BigDecimal getConvertedAmount() {
			return convertedAmount;
		}
		public void setConvertedAmount(BigDecimal convertedAmount) {
			this.convertedAmount = convertedAmount;
		}
		public int getPort() {
			return port;
		}
		public void setPort(int port) {
			this.port = port;
		}
		
		
}
