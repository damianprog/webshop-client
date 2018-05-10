package com.webshop.webapp.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.webshop.webapp.entity.Product;
import com.webshop.webapp.webservice.ProductWebservice;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductWebservice productWebservice;
	
	@Override
	public Product getProductById(int productId) {
		return productWebservice.getProduct(productId);
	}
	
	@Override
	public Product getProductByName(String productName) {
		return productWebservice.getProductByName(productName);
	}
	
	@Override
	public void saveProduct(Product product) {

		productWebservice.saveProduct(product);
		
	}

	@Override
	public Page<Product> getProductsByCategory(String category, int page) {
		return productWebservice.getProductsByCategory(category,page);
	}
	
	
	
}
