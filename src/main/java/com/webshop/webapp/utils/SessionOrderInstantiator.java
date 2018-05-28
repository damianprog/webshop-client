package com.webshop.webapp.utils;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.Order;

@Component
public class SessionOrderInstantiator {

	@Autowired
	private HttpSession session;
	
	public void instantiate() {
		
		Cart cart = (Cart) session.getAttribute("cart");
		
		Order order = new Order();
		order.setCartProducts(cart.getCartProducts());
		order.setOrderDate(String.valueOf(LocalDate.now()));

		session.setAttribute("order", order);
		
	}
	
}
