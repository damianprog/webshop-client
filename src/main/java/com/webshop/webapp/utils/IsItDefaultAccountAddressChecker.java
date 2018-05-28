package com.webshop.webapp.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.UserService;

@Component
public class IsItDefaultAccountAddressChecker {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	public boolean check(int addressId) {
		
		int userId = (int) session.getAttribute("userId");
		
		User user = userService.getUserById(userId);
		Address userDefaultAccountAddress = user.getUserDetails().getAddress();
		
		if(userDefaultAccountAddress.getId() == addressId)
			return true;
		else
			return false;
		
	}
	
}
