package com.webshop.webapp.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.CartProduct;
import com.webshop.webapp.entity.service.ProductService;

@Component
public class SessionCartProductsAdder {

	@Autowired
	HttpSession session;

	@Autowired
	ProductService productService;

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
			CartProduct cpNew = new CartProduct();
			cpNew.setProduct(productService.getProductById(productId));
			cpNew.setQuantity(quantity);
			cart.getCartProducts().add(cpNew);
		}

		session.setAttribute("cart", cart);
	}

}
