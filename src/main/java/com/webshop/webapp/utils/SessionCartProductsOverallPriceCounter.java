package com.webshop.webapp.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.CartProduct;

@Component
public class SessionCartProductsOverallPriceCounter {

	@Autowired
	private HttpSession session;

	
	public double countOverallValue() {

		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart.getCartProducts().isEmpty())
			return 0;
		
		double price = 0;

		for (CartProduct cp : cart.getCartProducts()) {
			price += cp.getPrice();
		}

		return price;

	}

}
