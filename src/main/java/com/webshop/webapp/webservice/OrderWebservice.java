package com.webshop.webapp.webservice;

import java.util.List;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.Order;

public interface OrderWebservice {

	public void saveOrder(Order order);

	public Order getOrderById(int id);

	public List<Order> getOrdersByUserId(int userId);

	public void saveCreditCard(CreditCard creditCard);

	public Address saveAddressAndReturn(Address address);

	public List<Order> getOrdersByCreditCardId(int creditCardId);

}
