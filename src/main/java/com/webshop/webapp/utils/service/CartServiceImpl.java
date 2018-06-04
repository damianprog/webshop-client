package com.webshop.webapp.utils.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.webapp.utils.SessionCartProductsAdder;
import com.webshop.webapp.utils.SessionCartProductsCounter;
import com.webshop.webapp.utils.SessionCartProductsOverallPriceCounter;
import com.webshop.webapp.utils.SessionCartProductsPhotosInitializer;
import com.webshop.webapp.utils.SessionCartProductsPriceInitializer;
import com.webshop.webapp.utils.SessionCartProductsRemover;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private SessionCartProductsAdder adder;

	@Autowired
	private SessionCartProductsCounter counter;

	@Autowired
	private SessionCartProductsPhotosInitializer photosInitializer;

	@Autowired
	private SessionCartProductsOverallPriceCounter overallPriceCounter;
	
	@Autowired
	private SessionCartProductsPriceInitializer priceInitializer;
	
	@Autowired
	private SessionCartProductsRemover remover;
	
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
	public void countPriceForEachCartProduct() {
		priceInitializer.initialize();
	}

	@Override
	public double countOverallCartProductsPrice() {
		return overallPriceCounter.countOverallValue();
	}

	@Override
	public void removeCartProduct(int productId) {
		remover.remove(productId);
	}

}
