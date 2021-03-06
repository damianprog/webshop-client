package com.webshop.webapp.webservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserRole;

@Service
public class UserWebserviceImpl implements UserWebservice {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://localhost:9000";

	@Override
	public User getUserByUserName(String userName) {

		Map<String, String> params = new HashMap<>();
		params.put("userName", userName);

		return restTemplate.getForObject(url + "/users/names/{userName}", User.class, params);
	}

	@Override
	public User getUserById(int userId) {

		Map<String, Integer> params = new HashMap<>();
		params.put("userId", userId);

		return restTemplate.getForObject(url + "/users/{userId}", User.class, params);
	}

	@Override
	public User saveUser(User user) {

		return restTemplate.postForObject(url + "/users", user,User.class);
	}

	@Override
	public void saveUserRole(UserRole userRole) {

		restTemplate.postForObject(url + "/userRoles", userRole, UserRole.class);

	}

	@Override
	public void updateUser(User user) {

		restTemplate.put(url + "/users",user);
		
	}


}
