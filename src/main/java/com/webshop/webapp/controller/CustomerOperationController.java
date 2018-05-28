package com.webshop.webapp.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webshop.webapp.entity.Product;
import com.webshop.webapp.entity.Review;
import com.webshop.webapp.entity.ReviewAndRating;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.ProductService;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.utils.ReviewAndRatingSaver;
import com.webshop.webapp.utils.service.PhotoService;

@Controller
@RequestMapping("/customer")
public class CustomerOperationController {

	@Autowired
	private ProductService productService;

	@Autowired
	private PhotoService photoService;

	@Autowired
	private UserService userService;

	@Autowired
	private ReviewAndRatingSaver reviewAndRatingSaver;

	@GetMapping("/writeReview")
	public String writeReview(Model theModel, @RequestParam("productId") int productId, Principal principal)
			throws IOException {

		Product product = productService.getProductById(productId);
		User user = userService.getUserByUserName(principal.getName());

		theModel.addAttribute("product", product);
		theModel.addAttribute("productPhoto",
				photoService.getEncodedImage(photoService.resize(product.getProductPhoto(), 150, 150)));
		theModel.addAttribute("userFirstName", user.getUserDetails().getAddress().getFirstName());
		theModel.addAttribute("review", new Review());
		return "writeReview";
	}

	@PostMapping("/saveReviewAndRating")
	public String saveReviewAndRating(Model theModel, @RequestParam("productId") int productId,
			 @ModelAttribute("review") Review review, Principal principal,
			RedirectAttributes ra,@RequestParam("rate") int rating) throws IOException {
		
		
		ReviewAndRating rat = new ReviewAndRating(productId,review,rating);
		
		reviewAndRatingSaver.save(rat);
		
		ra.addAttribute("productId",productId);
		return "redirect:/main/showProduct";
	}

}
