package com.microservicesintro.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EXCHANGE")
public class Exchange {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "FROM_CURRENCY")
	private String fromCurrency;
	@Column(name = "TO_CURRENCY")
	private String toCurrency;
	@Column(name = "CONVERSION_MULTIPLE")
	private BigDecimal conversionMultiple;
	@Column(name = "PORT")
	private int port;
	
	protected Exchange() {
		super();
	}
	
	public Exchange(String fromCurrency, String toCurrency, BigDecimal conversionMultiple) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.conversionMultiple = conversionMultiple;
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
	
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
}
