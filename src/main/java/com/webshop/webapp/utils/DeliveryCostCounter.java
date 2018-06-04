package com.webshop.webapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.enumeration.DeliveryTypes;
import com.webshop.webapp.utils.service.CartService;

@Component
public class DeliveryCostCounter {

	@Autowired
	private CartService cartService;

	public double count(String deliveryType) {

		if (deliveryType.equals(DeliveryTypes.TWODAYSHIPPING.deliveryTypeName())
				&& (cartService.countOverallCartProductsPrice() < 100))
			return 10;
		else
			return 0;

	}

}
