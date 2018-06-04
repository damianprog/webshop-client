package com.webshop.webapp.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.CreditCardOperationsParameters;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.CreditCardService;
import com.webshop.webapp.entity.service.UserService;

@Component
public class CreditCardSaver {

	@Autowired
	private BillingAddressSetter billingAddressSetter;
	
	@Autowired
	private DefaultCreditCardToNormalSetter defaultCreditCardToNormalSetter;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CreditCardService creditCardService;
	
	private Address billingAddress;
	
	private CreditCard creditCard;
	
	public void updateCreditCard(CreditCardOperationsParameters cdOperationsParams) {
		
		initializeFields(cdOperationsParams);
		
		creditCardService.update(creditCard);
		
	}
	
	public CreditCard saveCreditCard(CreditCardOperationsParameters cdOperationsParams) {
		
		initializeFields(cdOperationsParams);
		
		return creditCardService.save(creditCard);
		
		
	}

	private void initializeFields(CreditCardOperationsParameters cdOperationsParams) {
		billingAddress = billingAddressSetter.getBillingAddressForSaveOrUpdate(cdOperationsParams);
		
		creditCard = cdOperationsParams.getCreditCard();
		
		if(cdOperationsParams.isSetAsDefaultCreditCard()) {
			defaultCreditCardToNormalSetter.set();
			creditCard.setItDefault(true);
		}
		
		int userId = (int) session.getAttribute("userId");
		
		User user = userService.getUserById(userId);
		
		creditCard.setAddress(billingAddress);
		creditCard.setUser(user);
	}
	
}
