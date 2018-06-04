package com.webshop.webapp.factories;

import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Order;

@Component
public class OrderFactoryImpl extends OrderFactory{

	public Order createInstance() {
		return new Order();
	}
	
}
