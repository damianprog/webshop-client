package com.webshop.webapp.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserDetails;
import com.webshop.webapp.entity.UserRole;
import com.webshop.webapp.webservice.UserWebservice;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserWebservice userWebservice;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void saveUser(User user) {
		
		user = setBasicUserValues(user);

		user = userWebservice.saveUser(user);
		grantUserRoleAndSave(user);

	}

	private void grantUserRoleAndSave(User user) {
		
		UserRole userRole = new UserRole();
		
		userRole.setUserId(user.getId());
		userRole.setRoleId(2);

		userWebservice.saveUser(user);
		userWebservice.saveUserRole(userRole);
	}

	private User setBasicUserValues(User user) {
		user.setEnabled(false);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		return user;
	}

	@Override
	public boolean isUserNameAvailable(String userName) {

		User user = userWebservice.getUserByUserName(userName);

		if (user == null)
			return true;
		else
			return false;
	}

	@Override
	public User getUserByUserName(String userName) {
		return userWebservice.getUserByUserName(userName);
	}

	@Override
	public User getUserById(int userId) {
		return userWebservice.getUserById(userId);
	}

	@Override
	public void updateUser(User user) {

		userWebservice.updateUser(user);

	}

}
