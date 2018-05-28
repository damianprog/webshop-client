package com.webshop.webapp.utils;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.Order;
import com.webshop.webapp.entity.OrderDetails;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.OrderService;
import com.webshop.webapp.entity.service.UserService;

@Component
public class SessionOrderDetailsInstantiator {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserService userService;

	@Autowired
	private CustomBillingAddressGenerator customBillingAddressGenerator;

	@Autowired
	private OrderService orderService;

	@Autowired
	private SessionCartProductsPriceCounter counter;
	
	@Autowired
	private DefaultCreditCardToNormalSetter defaultCreditCardToNormalSetter;

	private Order order;

	private User user;

	private OrderDetails orderDetails;

	public void instantiate(OrderDetails orderDetails) {

		instantiateClassVariables(orderDetails);
		instantiateCreditCard();
		instantiateUser();
		instantiateCreditCardBillingAddress();
		instantiateDefaultCreditCard();
		countOverallOrderValue();
	}

	private void instantiateDefaultCreditCard() {
		CreditCard creditCard = order.getCreditCard();
		
		if(orderDetails.isItDefaultCreditCard() == true) {
			defaultCreditCardToNormalSetter.set();
		}
		
		creditCard.setItDefault(orderDetails.isItDefaultCreditCard());
	}

	private void countOverallOrderValue() {

		order.setOverallValue(counter.countOverallValue());

	}

	private void instantiateClassVariables(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
		this.user = userService.getUserByUserName((String) session.getAttribute("userName"));
		this.order = (Order) session.getAttribute("order");
	}

	private void instantiateCreditCard() {
		CreditCard creditCard = orderDetails.getCreditCard();
		creditCard.setUser(user);
		order.setCreditCard(creditCard);
	}

	private void instantiateUser() {
		order.setUser(user);
	}

	private void instantiateCreditCardBillingAddress() {

		if (orderDetails.isItDefaultAddress() == true) 
			setDefaultBillingAddress();
			else
			setCustomBillingAddress();

	}

	private void setDefaultBillingAddress() {
		Address userAddress = user.getUserDetails().getAddress();
		order.getCreditCard().setAddress(userAddress);
	}

	private void setCustomBillingAddress() {
		Address billingAddressObject = customBillingAddressGenerator.generate(orderDetails.getBillingAddress());
		order.getCreditCard().setAddress(orderService.saveAddressAndReturn(billingAddressObject));
	}

}
