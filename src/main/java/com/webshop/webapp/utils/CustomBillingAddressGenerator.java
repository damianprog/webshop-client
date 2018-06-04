package com.webshop.webapp.utils;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserDetails;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.factories.AddressFactory;

@Component
public class CustomBillingAddressGenerator {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressFactory addressFactory;

	public Address generate(Map<String, String> params) {

		User user = userService.getUserById((int) session.getAttribute("userId"));
		UserDetails userDetails = user.getUserDetails();

		Address billingAddress = addressFactory.createInstance();

		billingAddress.setFirstName(userDetails.getAddress().getFirstName());
		billingAddress.setLastName(userDetails.getAddress().getLastName());
		billingAddress.setPhone(userDetails.getAddress().getPhone());

		billingAddress.setStreet(params.get("street"));
		billingAddress.setCity(params.get("city"));
		billingAddress.setCountry(params.get("country"));
		billingAddress.setPostCode(params.get("postCode"));

		return billingAddress;

	}

}
