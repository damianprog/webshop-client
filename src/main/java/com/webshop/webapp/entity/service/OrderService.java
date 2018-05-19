package com.webshop.webapp.entity.service;

import java.util.List;

import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.Order;

public interface OrderService {

	public void saveOrder(Order order);
	
	public Order getOrderById(int id);
	
	public List<Order> getOrdersByUserId(int userId);
	
	public void saveCreditCard(CreditCard creditCard);
	
}
