package com.webshop.webapp.webservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	public void saveUser(User user) {

		restTemplate.put(url + "/users", user);
	}

	@Override
	public void saveUserRole(UserRole userRole) {

		restTemplate.postForObject(url + "/userRoles", userRole, UserRole.class);

	}

}
