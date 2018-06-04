package com.webshop.webapp.factories;

import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Address;

@Component
public class AddressFactoryImpl extends AddressFactory{

	public Address createInstance() {
		return new Address();
	}
	
}
