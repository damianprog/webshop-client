package com.webshop.webapp.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.webservice.CreditCardWebservice;

@Service
public class CreditCardServiceImpl implements CreditCardService{

	@Autowired
	private CreditCardWebservice creditCardWebservice;
	
	@Override
	public CreditCard getCreditCardById(int creditCardId) {
		return creditCardWebservice.getCreditCardById(creditCardId);
	}

	@Override
	public List<CreditCard> getCreditCardsByUserId(int userId) {
		return creditCardWebservice.getCreditCardsByUserId(userId);
	}

	@Override
	public CreditCard getDefaultCreditCardByUserId(int userId) {
		return creditCardWebservice.getDefaultCreditCardByUserId(userId);
	}

	@Override
	public void save(CreditCard creditCard) {
		creditCardWebservice.save(creditCard);
		
	}

	@Override
	public void update(CreditCard creditCard) {
		creditCardWebservice.update(creditCard);
		
	}

	@Override
	public void removeCreditCardById(int creditCardId) {
		creditCardWebservice.removeCreditCardById(creditCardId);
	}

}
