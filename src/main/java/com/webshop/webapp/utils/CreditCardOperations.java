package com.webshop.webapp.utils;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.AddressService;
import com.webshop.webapp.entity.service.CreditCardService;
import com.webshop.webapp.entity.service.UserService;

@Component
public class CreditCardOperations {

	@Autowired
	private UserService userService;

	@Autowired
	private CustomBillingAddressGenerator customBillingAddressGenerator;

	@Autowired
	private DefaultCreditCardToNormalSetter defaultCreditCardToNormalSetter;

	@Autowired
	private CreditCardService creditCardService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private HttpSession session;

	@Autowired
	private IsItDefaultAccountAddressChecker isItDefaultAccountAddressChecker;
	
	private Map<String, String> parameters;

	private Address billingAddress;

	private User user;

	private int addressId;
	
	private boolean setAsDefaultCreditCard;

	private boolean setDefaultAddress;

	private boolean updateCreditCard;

	public void change(CreditCard creditCard, Map<String, String> parameters) {

		initializeThisObjectFields(parameters);

		setBillingAddressForSaveOrUpdate();

		if (setAsDefaultCreditCard) {
			defaultCreditCardToNormalSetter.set();
		}
		
		saveOrUpdateCreditCard(creditCard);
	
		if((!setDefaultAddress) && (!isItDefaultAccountAddressChecker.check(addressId))) {
			addressService.deleteAddressById(addressId);
		}
	}

	private void initializeThisObjectFields(Map<String, String> parameters) {
		int userId = (int) session.getAttribute("userId");

		this.parameters = parameters;
		this.user = userService.getUserById(userId);
		this.setAsDefaultCreditCard = Boolean.valueOf(parameters.get("setAsDefaultCreditCard"));
		this.setDefaultAddress = Boolean.valueOf(parameters.get("setDefaultAddress"));
		this.updateCreditCard = Boolean.valueOf(parameters.get("updateCreditCard"));
		this.addressId = Integer.valueOf(parameters.get("addressId"));
	}

	private void setBillingAddressForSaveOrUpdate() {

		if (updateCreditCard)
			billingAddressWhenUpdatingCard();
		else
			billingAddressWhenSavingNewCard();

	}

	private Address billingAddressWhenUpdatingCard() {

		if (setDefaultAddress)
			billingAddress = addressService.getAddressById(addressId);
		else
			billingAddress = customBillingAddressGenerator.generate(parameters);

		return billingAddress;
	}

	private Address billingAddressWhenSavingNewCard() {

		if (setDefaultAddress)
			billingAddress = user.getUserDetails().getAddress();
		else
			billingAddress = customBillingAddressGenerator.generate(parameters);

		return billingAddress;
	}

	private void saveOrUpdateCreditCard(CreditCard creditCard) {
		
		creditCard.setAddress(billingAddress);
		creditCard.setUser(user);
		creditCard.setItDefault(setAsDefaultCreditCard);

		if (updateCreditCard)
			creditCardService.update(creditCard);
		else
			creditCardService.save(creditCard);
	}

}
