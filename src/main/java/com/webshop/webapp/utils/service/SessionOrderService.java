package com.webshop.webapp.utils.service;

import java.util.Map;

import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.CreditCardOperationsParameters;
import com.webshop.webapp.entity.OrderDetails;

public interface SessionOrderService {

	public void instantiateOrder();
	
	public void instantiateOrderDetails(Map<String,String> params,CreditCard creditCard);
	
	public void instantiateOrderDelivery(String deliveryType);
	
}
