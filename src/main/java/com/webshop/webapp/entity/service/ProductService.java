package com.webshop.webapp.entity.service;

import com.webshop.webapp.entity.Product;

public interface ProductService {

	public void saveProduct(Product product);
	
	public Product getProductById(int productId);
	
	public Product getProductByName(String productName);
	
}
