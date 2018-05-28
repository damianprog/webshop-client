package com.webshop.webapp.utils;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.CartProduct;
import com.webshop.webapp.entity.Product;
import com.webshop.webapp.utils.service.PhotoService;

@Component
public class CartProductsPhotosInitializer {

	@Autowired
	PhotoService photoService;
	
	public List<CartProduct> initialize(List<CartProduct> cartProducts,int width,int height) {
		
		for (CartProduct cp : cartProducts) {

			Product product = cp.getProduct();

			String encodedResizedPhoto = encodeAndResize(product,width,height);
			product.setEncodedProductPhoto(encodedResizedPhoto);
		}

		return cartProducts;
		
	}

	private String encodeAndResize(Product product,int width,int height) {
		
		String encodedResizedPhoto = null;
		
		try {
			encodedResizedPhoto = photoService
					.getEncodedImage(photoService.resize(product.getProductPhoto(), width, height));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return encodedResizedPhoto;
	}
	
}
