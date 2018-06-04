package com.webshop.webapp.factories;

import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.CreditCard;

@Component
public class CreditCardFactoryImpl extends CreditCardFactory{

	@Override
	public CreditCard createInstance() {
		return new CreditCard();
	}

}
