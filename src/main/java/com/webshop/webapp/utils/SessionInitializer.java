package com.webshop.webapp.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.User;

@Component
public class SessionInitializer {

	@Autowired
	HttpSession session;
	
	public void initialize(User user) {
		
		session.setAttribute("userSession", user);
		session.setAttribute("userId", user.getId());
		session.setAttribute("cart", new Cart());
		session.setAttribute("userName", user.getUserName());
		
	}
	
}
