package com.webshop.webapp.webservice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.Order;

@Service
public class OrderWebserviceImpl implements OrderWebservice {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://localhost:9000";

	@Override
	public void saveOrder(Order order) {

		restTemplate.postForObject(url + "/orders", order, Order.class);

	}

	@Override
	public Order getOrderById(int id) {

		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);

		return restTemplate.getForObject(url + "/orders/{id}", Order.class, params);

	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {

		Map<String, Integer> params = new HashMap<>();
		params.put("userId", userId);

		ResponseEntity<Order[]> responseEntity = restTemplate.getForEntity(url + "/users/{userId}/orders",
				Order[].class, params);
		
		return Arrays.asList(responseEntity.getBody());

	}

	@Override
	public void saveCreditCard(CreditCard creditCard) {
		restTemplate.postForObject(url + "/creditCards", creditCard,CreditCard.class);
		
	}

	@Override
	public Address saveAddressAndReturn(Address address) {
		return restTemplate.postForObject(url + "/addresses", address,Address.class);
	}

	@Override
	public List<Order> getOrdersByCreditCardId(int creditCardId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("creditCardId", creditCardId);

		ResponseEntity<Order[]> responseEntity = restTemplate.getForEntity(url + "/orders/creditCards/{creditCardId}",
				Order[].class, params);
		
		return Arrays.asList(responseEntity.getBody());
	}

}
