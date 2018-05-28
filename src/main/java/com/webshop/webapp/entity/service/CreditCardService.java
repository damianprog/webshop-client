package com.webshop.webapp.entity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webshop.webapp.entity.CreditCard;

public interface CreditCardService {

	public CreditCard getCreditCardById(int creditCardId);
	
	public List<CreditCard> getCreditCardsByUserId(int userId);
	
	public CreditCard getDefaultCreditCardByUserId(int userId);
	
	public void save(CreditCard creditCard);
	
	public void update(CreditCard creditCard);

	public void removeCreditCardById(int creditCardId);
	
}
