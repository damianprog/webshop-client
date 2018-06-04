package com.webshop.webapp.entity;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CreditCardOperationsParameters {

	private Map<String, String> paramsMap;

	private User user;

	private int addressId;

	private Address billingAddress;

	private boolean setAsDefaultCreditCard;

	private boolean setDefaultAddress;

	private boolean updateCreditCard;
	
	private boolean isItOrderCreation;

	private CreditCard creditCard;

	public void initializeCreditCardOperationsParameters(Map<String, String> params, CreditCard creditCard) {

		this.paramsMap = params;
		this.setAsDefaultCreditCard = Boolean.valueOf(params.get("setAsDefaultCreditCard"));
		this.setDefaultAddress = Boolean.valueOf(params.get("setDefaultAddress"));
		this.addressId = Integer.valueOf(params.get("addressId"));
		this.creditCard = creditCard;

	}

	public void initilizeSessionOrderDetailsParameters(boolean setDefaultAddress, Map<String, String> paramsMap) {

		this.setDefaultAddress = setDefaultAddress;
		this.paramsMap = paramsMap;
		this.updateCreditCard = false;

	}

	public User getUser() {
		return user;
	}

	public int getAddressId() {
		return addressId;
	}

	public boolean isSetAsDefaultCreditCard() {
		return setAsDefaultCreditCard;
	}

	public boolean isSetDefaultAddress() {
		return setDefaultAddress;
	}

	public boolean isUpdateCreditCard() {
		return updateCreditCard;
	}

	public Map<String, String> getParamsMap() {
		return paramsMap;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public void setSetDefaultAddress(boolean setDefaultAddress) {
		this.setDefaultAddress = setDefaultAddress;
	}

	public void setParamsMap(Map<String, String> paramsMap) {
		this.paramsMap = paramsMap;
	}

	public void setUpdateCreditCard(boolean updateCreditCard) {
		this.updateCreditCard = updateCreditCard;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;	
	}

	public boolean isItOrderCreation() {
		return isItOrderCreation;
	}

	public void setIsItOrderCreation(boolean isItOrderCreation) {
		this.isItOrderCreation = isItOrderCreation;
	}
}