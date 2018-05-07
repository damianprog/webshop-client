package com.webshop.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webshop.webapp.entity.Product;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/addProduct")
	public String addProduct(Model theModel) {

		theModel.addAttribute("product", new Product());

		return "addProduct";
	}
	
}
