package com.webshop.webapp.utils.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.webapp.utils.CartProductsAdder;
import com.webshop.webapp.utils.CartProductsCounter;
import com.webshop.webapp.utils.CartProductsPhotosInitializer;
import com.webshop.webapp.utils.CartProductsPriceCounter;
import com.webshop.webapp.utils.CartProductsRemover;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartProductsAdder adder;

	@Autowired
	CartProductsCounter counter;

	@Autowired
	CartProductsPhotosInitializer photosInitializer;

	@Autowired
	CartProductsPriceCounter priceCounter;
	
	@Autowired
	CartProductsRemover remover;
	
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
		return priceCounter.countOverallPrice();
	}

	@Override
	public void removeCartProduct(int productId) {
		remover.remove(productId);
	}

}
