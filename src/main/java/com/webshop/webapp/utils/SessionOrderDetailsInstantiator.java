package com.webshop.webapp.utils;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.CreditCardOperationsParameters;
import com.webshop.webapp.entity.Order;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.UserService;

@Component
public class SessionOrderDetailsInstantiator {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserService userService;

	@Autowired
	private SessionCartProductsOverallPriceCounter overallPriceCounter;

	@Autowired
	private CreditCardSaver creditCardSaver;
	
	private CreditCard creditCard;
	
	private Order order;

	private User user;

	@Autowired
	private CreditCardOperationsParameters cdOperationsParams;

	public void instantiate(Map<String,String> params,CreditCard creditCard) {
		
		cdOperationsParams.initializeCreditCardOperationsParameters(params, creditCard);
		cdOperationsParams.setIsItOrderCreation(true);
		
		instantiateThisObjectFields(cdOperationsParams);
		instantiateCreditCard();
		instantiateUser();
		countOverallOrderValue();
	}

	private void instantiateCreditCard() {

		creditCard = creditCardSaver.saveCreditCard(cdOperationsParams);
		order.setCreditCard(creditCard);
		
	}

	private void instantiateThisObjectFields(CreditCardOperationsParameters cdOperationsParams) {
		this.cdOperationsParams = cdOperationsParams;
		this.user = userService.getUserByUserName((String) session.getAttribute("userName"));
		this.order = (Order) session.getAttribute("order");
	}

	private void instantiateUser() {
		order.setUser(user);
	}

	private void countOverallOrderValue() {

		order.setOverallValue(overallPriceCounter.countOverallValue());

	}

}
