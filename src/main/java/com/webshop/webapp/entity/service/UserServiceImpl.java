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
	public boolean saveUser(User user) {

		UserRole userRole = new UserRole();

		UserDetails userDetails = new UserDetails();
		
		
		user.setEnabled(false);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserDetails(userDetails);
		
		if (isUserNameAvailable(user.getUserName())) {
			userWebservice.saveUser(user);
			User user2 = userWebservice.getUserByUserName(user.getUserName());
			userRole.setUserId(user2.getId());
			userRole.setRoleId(2);
			
			Address address = new Address();
			
			address.setId(user2.getId());
			userDetails.setAddress(address);
			userWebservice.saveUser(user2);
			userWebservice.saveUserRole(userRole);
			return true;
		}

		return false;
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
	
		userWebservice.saveUser(user);
		
	}
	
}
