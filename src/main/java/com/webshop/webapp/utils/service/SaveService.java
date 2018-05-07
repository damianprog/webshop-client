package com.webshop.webapp.utils.service;

import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserDetails;

public interface SaveService {

	public boolean saveUser(User user);
	
	public void saveUserDetails(UserDetails userDetails,String userName);
}
