package com.webshop.webapp.utils.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.webapp.utils.SessionCartProductsAdder;
import com.webshop.webapp.utils.SessionCartProductsCounter;
import com.webshop.webapp.utils.SessionCartProductsPhotosInitializer;
import com.webshop.webapp.utils.SessionCartProductsPriceCounter;
import com.webshop.webapp.utils.SessionCartProductsRemover;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	SessionCartProductsAdder adder;

	@Autowired
	SessionCartProductsCounter counter;

	@Autowired
	SessionCartProductsPhotosInitializer photosInitializer;

	@Autowired
	SessionCartProductsPriceCounter priceCounter;
	
	@Autowired
	SessionCartProductsRemover remover;
	
	@Override
	public void addCartProduct(int productId, int quantity) {
		adder.add(productId, quantity);
	}

	@Override
	public int countQuantityOfProductsInCart() {
		return counter.count();
	}

	@Override
	public void initializeCartProductsPhotos() {
		photosInitializer.initialize();
	}

	@Override
	public void countCartProductPrice() {
		 priceCounter.countCartProductPrice();
	}

	@Override
	public double countOverallCartProductsPrice() {
		return priceCounter.countOverallValue();
	}

	@Override
	public void removeCartProduct(int productId) {
		remover.remove(productId);
	}

}
