package com.webshop.webapp.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

	private int id;

	private Address address;

	private List<CartProduct> cartProducts;

	private User user;

	private String orderDate;

	private CreditCard creditCard;

	private double overallValue;

	private Delivery delivery;

	public Order() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getOverallValue() {
		return overallValue;
	}

	public void setOverallValue(double overallValue) {
		this.overallValue = overallValue;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", address=" + address + ", cartProducts=" + cartProducts + ", user=" + user
				+ ", orderDate=" + orderDate + ", creditCard=" + creditCard + ", overallValue=" + overallValue
				+ ", delivery=" + delivery + "]";
	}

}
