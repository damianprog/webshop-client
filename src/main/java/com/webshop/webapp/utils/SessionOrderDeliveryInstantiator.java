package com.webshop.webapp.utils;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Delivery;
import com.webshop.webapp.entity.Order;

@Component
public class SessionOrderDeliveryInstantiator {

	@Autowired
	private HttpSession session;
	
	public void instantiate(String deliveryType) {
		
		Order order = (Order) session.getAttribute("order");
		
		Delivery delivery = new Delivery();
		delivery.setDeliveryDate(String.valueOf(LocalDate.now().plusDays(3)));
		delivery.setDeliveryType(deliveryType);
		
		order.setDelivery(delivery);
		
	}
	
}
