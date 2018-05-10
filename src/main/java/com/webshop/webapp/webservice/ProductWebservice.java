package com.webshop.webapp.webservice;

import org.springframework.data.domain.Page;

import com.webshop.webapp.entity.Product;

public interface ProductWebservice {

	public void saveProduct(Product product);

	public Product getProduct(int productId);

	public Product getProductByName(String productName);

	public Page<Product> getProductsByCategory(String category, int page);
	
}
