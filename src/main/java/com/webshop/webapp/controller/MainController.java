package com.webshop.webapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webshop.webapp.entity.Product;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.ProductServiceImpl;
import com.webshop.webapp.utils.ProductsPhotosInitializer;
import com.webshop.webapp.utils.service.PhotoService;
import com.webshop.webapp.utils.service.SaveService;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	PhotoService photoService;

	@Autowired
	ProductServiceImpl productService;

	@Autowired
	SaveService saveService;

	@Autowired
	ProductsPhotosInitializer productsPhotosInitializer;
	
	@GetMapping("/start")
	public String start() {

		return "main";
	}

	@GetMapping("/showProduct")
	public String showProduct(Model theModel, @RequestParam("productId") int productId) throws IOException {

		Product product = productService.getProductById(productId);
		Product sponsored = product;

		theModel.addAttribute("productPhoto", photoService.getEncodedImage(product.getProductPhoto()));
		theModel.addAttribute("highlights", Arrays.asList(product.getHighlights().split(";")));
		theModel.addAttribute("product", product);
		theModel.addAttribute("arrivesDate", LocalDate.now().plusDays(3));
		theModel.addAttribute("sponsored", sponsored);
		theModel.addAttribute("sponsoredPhoto",
				photoService.getEncodedImage(photoService.resize(sponsored.getProductPhoto(), 150, 150)));

		return "product";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(Model theModel, @RequestParam("photo") MultipartFile productPhoto,
			@ModelAttribute("product") Product product) throws IOException {

		product.setProductPhoto(photoService.convertMultipartImage(productPhoto, 450, 450));

		productService.saveProduct(product);

		return "main";
	}

	@GetMapping("/addToCart")
	public String addToCart(Model theModel, @RequestParam("quantity") int quantity,
			@RequestParam(value = "carePlan", required = false) String carePlan) {

		return "main";
	}

	@GetMapping("/signUp")
	public String signUp(Model theModel) {

		theModel.addAttribute("user", new User());

		return "signUp";
	}

	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model theModel) {

		if (bindingResult.hasErrors())
			return "signUp";

		theModel.addAttribute("success", saveService.saveUser(user));

		return "created";
	}

	@GetMapping("/showCategory")
	public String showCategory(@RequestParam("category") String category, @RequestParam(defaultValue = "1") int page,
			Model theModel) {

		Page<Product> productsPage = productService.getProductsByCategory(category,page);
		
		theModel.addAttribute("products",productsPhotosInitializer.initialize(productsPage.getContent()));
		theModel.addAttribute("productsPage",productsPage);
		theModel.addAttribute("currentPage",page);
		theModel.addAttribute("category",category);
		
		return "category";
	}

	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}

}
