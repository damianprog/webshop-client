package com.webshop.webapp.webservice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.webshop.webapp.entity.CreditCard;

@Service
public class CreditCardWebserviceImpl implements CreditCardWebservice {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://localhost:9000";

	@Override
	public CreditCard getCreditCardById(int creditCardId) {
		
		Map<String,Integer> params = new HashMap<>();
		params.put("creditCardId", creditCardId);
				
		return restTemplate.getForObject(url + "/creditCards/{creditCardId}", CreditCard.class,params);
		
	}

	@Override
	public List<CreditCard> getCreditCardsByUserId(int userId) {
		Map<String,Integer> params = new HashMap<>();
		params.put("userId", userId);
				
		ResponseEntity<CreditCard[]> responseEntity =  restTemplate.getForEntity(url + "/users/{userId}/creditCards", CreditCard[].class,params);
		
		return Arrays.asList(responseEntity.getBody());
	}

	@Override
	public CreditCard getDefaultCreditCardByUserId(int userId) {
		Map<String,Integer> params = new HashMap<>();
		params.put("userId", userId);
				
		return restTemplate.getForObject(url + "/users/{userId}/creditCards/default", CreditCard.class,params);
	}

	@Override
	public void save(CreditCard creditCard) {
		restTemplate.postForObject(url + "/creditCards", creditCard, CreditCard.class);
	}

	@Override
	public void update(CreditCard creditCard) {
		restTemplate.put(url + "/creditCards", creditCard);
	}

	@Override
	public void removeCreditCardById(int creditCardId) {
		
		restTemplate.delete(url + "/creditCards/{creditCardId}/delete",creditCardId);
		
	}

}
