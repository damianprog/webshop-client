package com.webshop.webapp.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.service.ProductService;
import com.webshop.webapp.utils.service.CartService;
import com.webshop.webapp.utils.service.PhotoService;

@Controller
@RequestMapping("/logged")
public class LoggedController {

	@Autowired
	ProductService productService;

	@Autowired
	PhotoService photoService;

	@Autowired
	CartService cartService;
	
	@GetMapping("/addToCart")
	public String addToCart(Model theModel, HttpSession session, @RequestParam("productId") int productId,
			@RequestParam("quantity") int quantity, RedirectAttributes ra) {

		cartService.addCartProduct(productId, quantity);

		theModel.addAttribute("product", productService.getProductById(productId));

		ra.addAttribute("productId", productId);
		return "redirect:/main/showProduct";
	}

	@GetMapping("/showCart")
	public String showcart(Model theModel, HttpSession session) {

		Cart cart = (Cart) session.getAttribute("cart");

		cartService.initializeCartProductsPhotos();
		cartService.countCartProductPrice();

		theModel.addAttribute("overallQuantity", cartService.countQuantityOfProductsInCart());
		theModel.addAttribute("overallPrice", cartService.countOverallCartProductsPrice());
		theModel.addAttribute("cartProducts", cart.getCartProducts());

		return "cart";

	}

	@GetMapping("/removeCartProduct")
	public String removeCartProduct(Model theModel, HttpSession session, @RequestParam("productId") int productId) {

		cartService.removeCartProduct(productId);

		return "redirect:/logged/showCart";

	}

	@GetMapping("/showCheckoutShippingType")
	public String showCheckoutShippingType(Model theModel, HttpSession session) {

		Cart cart = (Cart) session.getAttribute("cart");
		
		theModel.addAttribute("cartProducts", cart.getCartProducts());
		theModel.addAttribute("overallQuantity", cartService.countQuantityOfProductsInCart());
		theModel.addAttribute("overallPrice", cartService.countOverallCartProductsPrice());
		theModel.addAttribute("arrivesDate", LocalDate.now().plusDays(3));
		
		return "checkoutShippingType";

	}
	
}
