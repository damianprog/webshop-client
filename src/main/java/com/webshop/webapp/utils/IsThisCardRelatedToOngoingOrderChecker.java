package com.webshop.webapp.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Order;
import com.webshop.webapp.entity.service.OrderService;

@Component
public class IsThisCardRelatedToOngoingOrderChecker {

	@Autowired
	private OrderService orderService;
	
	public boolean check(int creditCardId) {
		
		List<Order> ordersRelatedToThisCard = orderService.getOrdersByCreditCardId(creditCardId);
		
		if(!ordersRelatedToThisCard.isEmpty())
			return true;
		else
			return false;
		
	}
	
}
