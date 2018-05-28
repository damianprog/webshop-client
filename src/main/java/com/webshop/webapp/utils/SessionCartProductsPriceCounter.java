package com.webshop.webapp.utils;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.CartProduct;

@Component
public class SessionCartProductsPriceCounter {

	@Autowired
	HttpSession session;

	public void countCartProductPrice() {

		Cart cart = (Cart) session.getAttribute("cart");

		for (CartProduct cp : cart.getCartProducts())
			cp.setPrice(cp.getProduct().getPrice() * cp.getQuantity());

	}

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
