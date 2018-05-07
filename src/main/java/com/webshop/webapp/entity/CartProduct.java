package com.webshop.webapp.entity;

public class CartProduct {

	private Product product;
	
	private int quantity;
	
	public CartProduct() {
		quantity = 1;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
