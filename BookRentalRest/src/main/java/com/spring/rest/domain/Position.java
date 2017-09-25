package com.spring.rest.domain;
public class Position {
	private Stock stock;
	private int quantity;
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Position(Stock stock, int quantity) {
		super();
		this.stock = stock;
		this.quantity = quantity;
	}
	
	
}

