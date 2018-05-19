package com.webshop.webapp.utils;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserDetails;
import com.webshop.webapp.entity.service.UserService;

@Component
public class ObjectGenerator {

	@Autowired
	HttpSession session;

	@Autowired
	UserService userService;

	public Address generateCustomBillingAddressForLoggedUser(Map<String, String> params) {

		User user = userService.getUserByUserName((String) session.getAttribute("userName"));
		UserDetails userDetails = user.getUserDetails();

		Address billingAddress = new Address();

		billingAddress.setFirstName(userDetails.getFirstName());
		billingAddress.setLastName(userDetails.getLastName());
		billingAddress.setPhone(userDetails.getPhone());

		billingAddress.setStreet(params.get("street"));
		billingAddress.setCity(params.get("city"));
		billingAddress.setCountry(params.get("country"));
		billingAddress.setPostCode(params.get("postCode"));

		return billingAddress;

	}

}
