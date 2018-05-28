package com.webshop.webapp.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.webservice.AddressWebservice;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressWebservice addressWebservice;
	
	@Override
	public Address getAddressById(int id) {
		return addressWebservice.getAddressById(id);
	}

	@Override
	public void deleteAddressById(int addressId) {
		addressWebservice.deleteAddressById(addressId);
	}

}
