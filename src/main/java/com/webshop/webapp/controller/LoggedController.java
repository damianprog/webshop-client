package com.webshop.webapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webshop.webapp.entity.service.ProductService;
import com.webshop.webapp.utils.CartProductsAdder;

@Controller
@RequestMapping("/logged")
public class LoggedController {

	@Autowired
	ProductService productService;

	@Autowired
	CartProductsAdder adder;
	
	@GetMapping("/addToCart")
	public String addToCart(Model theModel, HttpSession session, @RequestAttribute("productId") int productId,
			@RequestAttribute("quantity") int quantity) {

		adder.add(productId, quantity);

		theModel.addAttribute("product", productService.getProductById(productId));

		return "product";
	}

}
