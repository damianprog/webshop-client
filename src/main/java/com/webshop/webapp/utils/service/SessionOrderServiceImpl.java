package com.webshop.webapp.utils.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.CreditCardOperationsParameters;
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
	public void instantiateOrderDetails(Map<String,String> params,CreditCard creditCard) {
		sessionOrderDetailsInstantiator.instantiate(params,creditCard);
	}

	@Override
	public void instantiateOrderDelivery(String deliveryType) {
		sessionOrderDeliveryInstantiator.instantiate(deliveryType);
	}

	
	
}
