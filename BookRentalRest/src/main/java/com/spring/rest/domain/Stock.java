package com.spring.rest.domain;
public class Stock {
	private String symbol;
	private String description;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(String symbol, String description) {
		super();
		this.symbol = symbol;
		this.description = description;
	}	
	
}