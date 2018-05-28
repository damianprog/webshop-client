package com.webshop.webapp.utils.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserDetails;
import com.webshop.webapp.entity.service.UserService;

@Service
public class SaveServiceImpl implements SaveService {

	@Autowired
	UserService userService;

	@Override
	public void saveUser(User user) {

		userService.saveUser(user);

	}

	@Override
	public void saveUserDetails(UserDetails userDetails, String userName) {

		User user = userService.getUserByUserName(userName);

		user.setUserDetails(userDetails);

		userService.updateUser(user);

	}

}
