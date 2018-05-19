package com.webshop.webapp.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.Order;
import com.webshop.webapp.webservice.OrderWebservice;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderWebservice orderWebservice;
	
	@Override
	public void saveOrder(Order order) {
		orderWebservice.saveOrder(order);
		
	}

	@Override
	public Order getOrderById(int id) {
		return orderWebservice.getOrderById(id);
	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {
		return orderWebservice.getOrdersByUserId(userId);
	}

	@Override
	public void saveCreditCard(CreditCard creditCard) {
		orderWebservice.saveCreditCard(creditCard);
	}

	
	
}
