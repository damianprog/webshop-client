package com.webshop.webapp.entity.service;

import org.springframework.data.domain.Page;

import com.webshop.webapp.entity.Product;

public interface ProductService {

	public void saveProduct(Product product);
	
	public Product getProductById(int productId);
	
	public Product getProductByName(String productName);
	
	public Page<Product> getProductsByCategory(String category, int page);
	
}
