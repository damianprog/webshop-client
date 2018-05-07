package com.webshop.webapp.webservice;

import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserRole;

public interface UserWebservice {

	public User getUserByUserName(String userName);
	
	public User getUserById(int userId);
	
	public void saveUser(User user);

	public void saveUserRole(UserRole userRole);
}
