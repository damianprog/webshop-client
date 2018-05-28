package com.webshop.webapp.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.CreditCardService;
import com.webshop.webapp.entity.service.UserService;

@Component
public class DefaultCreditCardToNormalSetter {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
	private UserService userService;
	
	public void set() {
		
		int loggedUserId = (int) session.getAttribute("userId");
		User user = userService.getUserById(loggedUserId);
		
		CreditCard creditCard = creditCardService.getDefaultCreditCardByUserId(loggedUserId);
		
		if(creditCard != null) {
			creditCard.setUser(user);
			creditCard.setItDefault(false);
			creditCardService.save(creditCard);
		}
		
		
	}
	
}
