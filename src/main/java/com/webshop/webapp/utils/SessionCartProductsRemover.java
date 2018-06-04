package com.webshop.webapp.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.CartProduct;

@Component
public class SessionCartProductsRemover {

	@Autowired
	private HttpSession session;
	
	public void remove(int productId) {
		
		Cart cart = (Cart) session.getAttribute("cart");

		for (CartProduct cp : cart.getCartProducts()) {
			if (cp.getProduct().getId() == productId) {
				cart.getCartProducts().remove(cp);
				break;
			}
		}

	}
	
}
