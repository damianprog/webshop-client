package com.webshop.webapp.utils.service;

import com.webshop.webapp.entity.Order;

public interface CartService {

	public void addCartProduct(int productId, int quantity);

	public int countQuantityOfProductsInCart();

	public void initializeCartProductsPhotos();

	public void countCartProductPrice();

	public double countOverallCartProductsPrice();

	public void removeCartProduct(int productId);
}
