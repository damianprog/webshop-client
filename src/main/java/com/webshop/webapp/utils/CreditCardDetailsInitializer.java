package com.webshop.webapp.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.CreditCardOperationsParameters;

@Component
public class CreditCardDetailsInitializer {

	@Autowired
	private CreditCardOperationsParameters cdOperationsParams;

	@Autowired
	private OldBillingAddressRemover oldBillingAddressRemover;
	
	@Autowired
	private CreditCardSaver creditCardSaver;
	
	public void prepareAndSaveCreditCard(CreditCard creditCard, Map<String, String> parameters) {

		cdOperationsParams.initializeCreditCardOperationsParameters(parameters,creditCard);

		if(Boolean.valueOf(parameters.get("updateCreditCard"))) {
			creditCardSaver.updateCreditCard(cdOperationsParams);
		}
		else
			creditCardSaver.saveCreditCard(cdOperationsParams);
		
		oldBillingAddressRemover.removeOrNotOldBillingAddress(cdOperationsParams);
		
	}

}
