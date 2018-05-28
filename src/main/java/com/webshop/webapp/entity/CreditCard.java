package com.webshop.webapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCard {

	private int id;

	private String firstName;

	private String lastName;

	private String cardNumber;

	private String monthExpiration;

	private String yearExpiration;

	private String securityCode;

	private String phoneNumber;

	private Address address;

	private User user;

	private boolean isItDefault;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getMonthExpiration() {
		return monthExpiration;
	}

	public void setMonthExpiration(String monthExpiration) {
		this.monthExpiration = monthExpiration;
	}

	public String getYearExpiration() {
		return yearExpiration;
	}

	public void setYearExpiration(String yearExpiration) {
		this.yearExpiration = yearExpiration;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isItDefault() {
		return isItDefault;
	}

	public void setItDefault(boolean isItDefault) {
		this.isItDefault = isItDefault;
	}

}
