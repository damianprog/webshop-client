package com.webshop.webapp.utils;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.CartProduct;
import com.webshop.webapp.entity.Product;
import com.webshop.webapp.utils.service.PhotoService;

@Component
public class SessionCartProductsPhotosInitializer {

	@Autowired
	private PhotoService photoService;

	@Autowired
	private HttpSession session;

	public void initialize() {

		Cart cart = (Cart) session.getAttribute("cart");

		for (CartProduct cp : cart.getCartProducts()) {

			Product product = cp.getProduct();

			String encodedResizedPhoto = encodeAndResize(product);
			product.setEncodedProductPhoto(encodedResizedPhoto);
		}

	}

	private String encodeAndResize(Product product) {
		
		String encodedResizedPhoto = null;
		
		try {
			encodedResizedPhoto = photoService
					.getEncodedImage(photoService.resize(product.getProductPhoto(), 100, 100));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return encodedResizedPhoto;
	}

}
