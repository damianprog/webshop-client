package com.webshop.webapp.entity.service;

import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserDetails;

public interface UserService {

	public boolean saveUser(User user);

	public boolean isUserNameAvailable(String userName);

	public User getUserByUserName(String userName);

	public User getUserById(int userId);

	public void updateUser(User user);
	
}