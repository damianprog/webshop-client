package com.webshop.webapp.utils.service;

import com.webshop.webapp.entity.OrderDetails;

public interface SessionOrderService {

	public void instantiateOrder();
	
	public void instantiateOrderDetails(OrderDetails orderDetails);
	
	public void instantiateOrderDelivery(String deliveryType);
	
}
