package com.webshop.webapp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webshop.webapp.entity.Product;
import com.webshop.webapp.entity.service.ProductService;
import com.webshop.webapp.utils.service.PhotoService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/addProduct")
	public String addProduct(Model theModel) {

		theModel.addAttribute("product", new Product());

		return "addProduct";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(Model theModel, @RequestParam("photo") MultipartFile productPhoto,
			@ModelAttribute("product") Product product) throws IOException {

		product.setProductPhoto(photoService.convertMultipartImage(productPhoto, 450, 450));

		productService.saveProduct(product);

		return "main";
	}
	
}
