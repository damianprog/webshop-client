package com.webshop.webapp.entity.service;

import com.webshop.webapp.entity.Address;

public interface AddressService {

	public Address getAddressById(int id);

	public void deleteAddressById(int addressId);
	
	public Address saveAddressAndReturn(Address address);
	
}
