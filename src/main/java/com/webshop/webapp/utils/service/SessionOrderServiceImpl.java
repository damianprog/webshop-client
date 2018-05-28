package com.webshop.webapp.utils.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.webapp.entity.OrderDetails;
import com.webshop.webapp.utils.SessionOrderDeliveryInstantiator;
import com.webshop.webapp.utils.SessionOrderDetailsInstantiator;
import com.webshop.webapp.utils.SessionOrderInstantiator;

@Service
public class SessionOrderServiceImpl implements SessionOrderService{

	@Autowired
	private SessionOrderInstantiator sessionOrderInstantiator;
	
	@Autowired
	private SessionOrderDetailsInstantiator sessionOrderDetailsInstantiator;
	
	@Autowired
	private SessionOrderDeliveryInstantiator sessionOrderDeliveryInstantiator;
	
	@Override
	public void instantiateOrder() {
		sessionOrderInstantiator.instantiate();
	}

	@Override
	public void instantiateOrderDetails(OrderDetails orderDetails) {
		sessionOrderDetailsInstantiator.instantiate(orderDetails);
	}

	@Override
	public void instantiateOrderDelivery(String deliveryType) {
		sessionOrderDeliveryInstantiator.instantiate(deliveryType);
	}

	
	
}
