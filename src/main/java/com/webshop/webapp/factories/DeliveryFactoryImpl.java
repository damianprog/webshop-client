package com.webshop.webapp.factories;

import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Delivery;

@Component
public class DeliveryFactoryImpl extends DeliveryFactory{

	public Delivery createInstance() {
		return new Delivery();
	}
	
}
