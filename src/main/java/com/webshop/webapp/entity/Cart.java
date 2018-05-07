package com.webshop.webapp.entity;

import java.util.ArrayList;

public class Cart {

	private ArrayList<CartProduct> cartProducts;

	public Cart() {
		cartProducts = new ArrayList<>();
	}
	
	public ArrayList<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(ArrayList<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	
	
}
