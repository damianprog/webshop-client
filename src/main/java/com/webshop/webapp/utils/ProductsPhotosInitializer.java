package com.webshop.webapp.utils;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Product;
import com.webshop.webapp.utils.service.PhotoService;

@Component
public class ProductsPhotosInitializer {

	@Autowired
	private PhotoService photoService;
	
	public List<Product> initialize(List<Product> products){
		
		for(Product p : products) {
			
			byte[] productPhotoBytes = null;
			
			try { 
				productPhotoBytes = photoService.resize(p.getProductPhoto(),200,200);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			p.setEncodedProductPhoto(photoService.getEncodedImage(productPhotoBytes));
			
		}
		
		return products;
		
	}
	
}
