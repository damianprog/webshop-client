package com.webshop.webapp.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.CartProduct;

@Component
public class CartProductsCounter {

	@Autowired
	HttpSession session;

	public int count() {

		Cart cart = (Cart) session.getAttribute("cart");
		
		int quantity = 0;

		for (CartProduct cp : cart.getCartProducts())
			quantity += cp.getQuantity();

		return quantity;
	}

}
