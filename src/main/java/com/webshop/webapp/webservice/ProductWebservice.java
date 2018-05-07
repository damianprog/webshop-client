package com.webshop.webapp.webservice;

import com.webshop.webapp.entity.Product;

public interface ProductWebservice {

	public void saveProduct(Product product);

	public Product getProduct(int productId);

	public Product getProductByName(String productName);
	
}
