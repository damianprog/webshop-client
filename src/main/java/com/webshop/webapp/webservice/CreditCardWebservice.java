package com.webshop.webapp.webservice;

import java.util.List;

import com.webshop.webapp.entity.CreditCard;

public interface CreditCardWebservice {

	public CreditCard getCreditCardById(int creditCardId);

	public List<CreditCard> getCreditCardsByUserId(int userId);

	public CreditCard getDefaultCreditCardByUserId(int userId);

	public CreditCard save(CreditCard creditCard);

	public void update(CreditCard creditCard);

	public void removeCreditCardById(int creditCardId);

}
