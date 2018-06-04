package com.webshop.webapp.webservice;

import com.webshop.webapp.entity.Address;

public interface AddressWebservice {

	public Address getAddressById(int id);

	public void deleteAddressById(int addressId);

	public Address saveAddressAndReturn(Address address);
	
}
