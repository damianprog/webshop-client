package com.webshop.webapp.webservice;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserRole;

public interface UserWebservice {

	public User getUserByUserName(String userName);

	public User getUserById(int userId);

	public User saveUser(User user);
	
	public void updateUser(User user);

	public void saveUserRole(UserRole userRole);

}
