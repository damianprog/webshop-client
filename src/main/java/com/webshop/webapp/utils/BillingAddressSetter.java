package com.webshop.webapp.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.CreditCardOperationsParameters;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.AddressService;
import com.webshop.webapp.entity.service.UserService;

@Component
public class BillingAddressSetter {

	@Autowired
	private CustomBillingAddressGenerator customBillingAddressGenerator;

	@Autowired
	private AddressService addressService;

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	private Address billingAddress;

	private CreditCardOperationsParameters cdOperationsParams;

	private User user;

	private boolean isSetAddressById = false;
	
	public Address getBillingAddressForSaveOrUpdate(CreditCardOperationsParameters cdOperationsParams) {

		initializeThisObjectFields(cdOperationsParams);
		
		if (cdOperationsParams.isSetDefaultAddress() == false) {
			billingAddress = customBillingAddressGenerator.generate(cdOperationsParams.getParamsMap());
			billingAddress = addressService.saveAddressAndReturn(billingAddress);
		}
		else 
			setProperBillingAddress();

		return billingAddress;
	}

	private void initializeThisObjectFields(CreditCardOperationsParameters cdOperationsParams) {

		int userId = (int) session.getAttribute("userId");

		this.user = userService.getUserById(userId);
		this.cdOperationsParams = cdOperationsParams;
	}
	
	private void setProperBillingAddress() {
		
		if(cdOperationsParams.isUpdateCreditCard() || cdOperationsParams.isItOrderCreation())
			isSetAddressById = true;
		
		if (isSetAddressById)
			setAddressById();
		else
			setAddressFromUserDetails();
	}

	private Address setAddressById() {

		billingAddress = addressService.getAddressById(cdOperationsParams.getAddressId());

		return billingAddress;
	}

	private Address setAddressFromUserDetails() {

		billingAddress = user.getUserDetails().getAddress();

		return billingAddress;
	}

}
