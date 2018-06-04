package com.webshop.webapp.utils;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.Order;
import com.webshop.webapp.factories.OrderFactory;

@Component
public class SessionOrderInstantiator {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private OrderFactory orderFactory;
	
	public void instantiate() {
		
		Cart cart = (Cart) session.getAttribute("cart");
		
		Order order = orderFactory.createInstance();
		order.setCartProducts(cart.getCartProducts());
		order.setOrderDate(String.valueOf(LocalDate.now()));

		session.setAttribute("order", order);
		
	}
	
}
