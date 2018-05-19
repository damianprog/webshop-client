package com.webshop.webapp.entity.service;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.User;

public interface UserService {

	public boolean saveUser(User user);

	public boolean isUserNameAvailable(String userName);

	public User getUserByUserName(String userName);

	public User getUserById(int userId);

	public void updateUser(User user);

}
