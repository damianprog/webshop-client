package com.webshop.webapp.entity;

import java.util.Map;

public class OrderDetails {

	private boolean isItDefaultAddress;

	private boolean isItDefaultCreditCard;

	private Map<String, String> billingAddress;

	private CreditCard creditCard;

	public OrderDetails(boolean isItDefaultAddress, boolean isItDefaultCreditCard, Map<String, String> billingAddress,
			CreditCard creditCard) {
		this.isItDefaultAddress = isItDefaultAddress;
		this.isItDefaultCreditCard = isItDefaultCreditCard;
		this.billingAddress = billingAddress;
		this.creditCard = creditCard;
	}

	public OrderDetails() {

	}

	public boolean isItDefaultAddress() {
		return isItDefaultAddress;
	}

	public void setItDefaultAddress(boolean isItDefaultAddress) {
		this.isItDefaultAddress = isItDefaultAddress;
	}

	public boolean isItDefaultCreditCard() {
		return isItDefaultCreditCard;
	}

	public void setItDefaultCreditCard(boolean isItDefaultCreditCard) {
		this.isItDefaultCreditCard = isItDefaultCreditCard;
	}

	public Map<String, String> getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Map<String, String> billingAddress) {
		this.billingAddress = billingAddress;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

}
