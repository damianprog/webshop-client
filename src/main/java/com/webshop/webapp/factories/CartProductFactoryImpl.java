package com.webshop.webapp.factories;

import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.CartProduct;

@Component
public class CartProductFactoryImpl extends CartProductFactory{

	@Override
	public CartProduct createInstance() {
		return new CartProduct();
	}

}
