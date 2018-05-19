package com.webshop.webapp.entity;

import java.util.Map;

public class OrderDetails {

	private boolean isItCustomAddress;

	private Map<String, String> billingAddress;

	private CreditCard creditCard;

	public OrderDetails(boolean isItCustomAddress, Map<String, String> billingAddress, CreditCard creditCard) {
		this.isItCustomAddress = isItCustomAddress;
		this.billingAddress = billingAddress;
		this.creditCard = creditCard;
	}

	public OrderDetails() {
		
	}
	
	public boolean isItCustomAddress() {
		return isItCustomAddress;
	}

	public void setItCustomAddress(boolean isItCustomAddress) {
		this.isItCustomAddress = isItCustomAddress;
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
