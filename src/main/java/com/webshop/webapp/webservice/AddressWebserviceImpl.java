package com.webshop.webapp.webservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.webshop.webapp.entity.Address;

@Service
public class AddressWebserviceImpl implements AddressWebservice{

	@Autowired
	private RestTemplate restTemplate;
	
	private String url = "http://localhost:9000";
	
	@Override
	public Address getAddressById(int id) {
		
		Map<String,Integer> params = new HashMap<>();
		params.put("addressId", id);
		
		return restTemplate.getForObject(url + "/addresses/{addressId}", Address.class, params);
		
	}

	@Override
	public void deleteAddressById(int addressId) {
		Map<String,Integer> params = new HashMap<>();
		params.put("addressId", addressId);
		
		restTemplate.delete(url + "/addresses/{addressId}/delete",params);
		
	}

	@Override
	public Address saveAddressAndReturn(Address address) {
		
		return restTemplate.postForObject(url + "/addresses", address, Address.class);
		
	}

}
