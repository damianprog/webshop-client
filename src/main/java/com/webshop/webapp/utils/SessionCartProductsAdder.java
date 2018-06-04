package com.webshop.webapp.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.CartProduct;
import com.webshop.webapp.entity.service.ProductService;
import com.webshop.webapp.factories.CartProductFactory;

@Component
public class SessionCartProductsAdder {

	@Autowired
	private HttpSession session;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartProductFactory cartProductFactory;
	
	public void add(int productId, int quantity) {
		Cart cart = (Cart) session.getAttribute("cart");
		boolean contains = false;

		for (CartProduct cp : cart.getCartProducts()) {

			if (cp.getProduct().getId() == productId) {
				cp.setQuantity(cp.getQuantity() + quantity);
				contains = true;
				break;
			}

		}

		if (contains == false) {
			CartProduct cpNew = cartProductFactory.createInstance();
			cpNew.setProduct(productService.getProductById(productId));
			cpNew.setQuantity(quantity);
			cart.getCartProducts().add(cpNew);
		}

		session.setAttribute("cart", cart);
	}

}
