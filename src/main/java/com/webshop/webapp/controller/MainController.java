package com.webshop.webapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import javax.servlet.http.HttpSession;
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

import com.webshop.webapp.entity.Product;
import com.webshop.webapp.entity.Review;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserDetails;
import com.webshop.webapp.entity.service.ProductService;
import com.webshop.webapp.entity.service.ReviewService;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.utils.AverageRatingGetter;
import com.webshop.webapp.utils.ProductsPhotosInitializer;
import com.webshop.webapp.utils.SponsoredModelInitializer;
import com.webshop.webapp.utils.service.PhotoService;
import com.webshop.webapp.utils.service.SaveService;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private PhotoService photoService;

	@Autowired
	private ProductService productService;

	@Autowired
	private SaveService saveService;

	@Autowired
	private ProductsPhotosInitializer productsPhotosInitializer;

	@Autowired
	private UserService userService;

	@Autowired
	private AverageRatingGetter averageRatingGetter;

	@Autowired
	private SponsoredModelInitializer sponsoredModelInitializer;

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/start")
	public String start() {

		return "main";
	}

	@GetMapping("/showProduct")
	public String showProduct(Model theModel, @RequestParam("productId") int productId,
			@RequestParam(defaultValue = "1") int page) throws IOException {

		Product product = productService.getProductById(productId);

		Page<Review> reviewsPage = reviewService.getReviewsByProductIdPageable(productId,page);

		theModel.addAttribute("reviewsPage",reviewsPage);
		theModel.addAttribute("productPhoto", photoService.getEncodedImage(product.getProductPhoto()));
		theModel.addAttribute("highlights", Arrays.asList(product.getHighlights().split(";")));
		theModel.addAttribute("product", product);
		theModel.addAttribute("arrivesDate", LocalDate.now().plusDays(3));
		theModel.addAttribute("averageRating", averageRatingGetter.get(productId));
		theModel.addAllAttributes(sponsoredModelInitializer.getModelMap());
		theModel.addAttribute("reviews", reviewsPage.getContent());
		

		return "product";
	}

	@GetMapping("/signUp")
	public String signUp(Model theModel) {

		theModel.addAttribute("user", new User());

		return "signUp";
	}

	@PostMapping("/showRegisterShippingAddress")
	public String showRegisterShippingAddress(Model theModel, @Valid @ModelAttribute("user") User user,
			BindingResult bindingResult, HttpSession session) {

		if (bindingResult.hasErrors())
			return "signUp";

		if (!userService.isUserNameAvailable(user.getUserName())) {
			theModel.addAttribute("success", false);
			return "registrationProcessInfo";
		}

		session.setAttribute("registerUser", user);

		theModel.addAttribute("userDetails", new UserDetails());

		return "registerShippingAddress";

	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("userDetails") UserDetails userDetails, Model theModel,
			HttpSession session) {

		User user = (User) session.getAttribute("registerUser");
		user.setUserDetails(userDetails);

		saveService.saveUser(user);

		theModel.addAttribute("success", true);

		session.removeAttribute("registerUser");

		return "registrationProcessInfo";
	}

	@GetMapping("/showCategory")
	public String showCategory(@RequestParam("category") String category, @RequestParam(defaultValue = "1") int page,
			Model theModel) {

		Page<Product> productsPage = productService.getProductsByCategory(category, page);

		theModel.addAttribute("products", productsPhotosInitializer.initialize(productsPage.getContent()));
		theModel.addAttribute("productsPage", productsPage);
		theModel.addAttribute("currentPage", page);
		theModel.addAttribute("category", category);

		return "category";
	}

	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}

}
