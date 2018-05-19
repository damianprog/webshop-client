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
import com.webshop.webapp.entity.service.UserService;

@Component
public class SessionOrderInstantiator {

	@Autowired
	HttpSession session;

	@Autowired
	UserService userService;

	@Autowired
	ObjectGenerator objectGenerator;

	private Order order;

	private User user;

	public void instantiate(OrderDetails orderDetails) {
		setOrderAndUser();
		instantiateCreditCard(orderDetails.getCreditCard());
		instantiateUser();
		instantiateCreditCardBillingAddress(orderDetails.isItCustomAddress(), orderDetails.getBillingAddress());

	}

	private void setOrderAndUser() {
		this.user = userService.getUserByUserName((String) session.getAttribute("userName"));
		this.order = (Order) session.getAttribute("order");
	}

	private void instantiateCreditCard(CreditCard creditCard) {
		order.setCreditCard(creditCard);
	}
	
	private void instantiateUser() {
		order.setUser(user);
	}

	private void instantiateCreditCardBillingAddress(boolean isItCustomAddress, Map<String, String> billingAddress) {

		if (isItCustomAddress == false)
			setDefaultAddress(billingAddress);
		else
			setCustomAddress();

	}

	private void setDefaultAddress(Map<String, String> billingAddress) {
		Address billingAddressObject = objectGenerator.generateCustomBillingAddressForLoggedUser(billingAddress);
		order.getCreditCard().setAddress(billingAddressObject);
	}

	private void setCustomAddress() {
		Address userAddress = user.getUserDetails().getAddress();
		order.getCreditCard().setAddress(userAddress);
	}

}
