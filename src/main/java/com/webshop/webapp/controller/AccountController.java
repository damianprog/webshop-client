package com.webshop.webapp.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.Order;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserDetails;
import com.webshop.webapp.entity.service.CreditCardService;
import com.webshop.webapp.entity.service.OrderService;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.utils.CartProductsPhotosInitializer;
import com.webshop.webapp.utils.CreditCardOperations;
import com.webshop.webapp.utils.service.SaveService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private UserService userService;

	@Autowired
	private SaveService saveService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private CartProductsPhotosInitializer cpPhotosInitializer;

	@Autowired
	private CreditCardService creditCardService;

	@Autowired
	private CreditCardOperations creditCardOperations;

	@GetMapping("/showShippingAddress")
	public String shippingAddressPage(Model theModel, Principal principal) {

		User user = userService.getUserByUserName(principal.getName());

		theModel.addAttribute("userDetails", user.getUserDetails());

		return "shippingAddress";
	}

	@GetMapping("/showAccount")
	public String showAccount(Model theModel, Principal principal, HttpSession session) {

		List<Order> orders = orderService.getOrdersForLoggedUser();

		theModel.addAttribute("orders", orders);

		return "account";
	}

	@PostMapping("/saveShippingAddress")
	public String saveShippingAddresses(Model theModel, Principal principal,
			@ModelAttribute("userDetails") UserDetails userDetails) {

		saveService.saveUserDetails(userDetails, principal.getName());

		return "account";
	}

	@GetMapping("/showFullOrder")
	public String showFullOrder(Model theModel, @RequestParam("orderId") int orderId) {

		Order order = orderService.getOrderById(orderId);

		cpPhotosInitializer.initialize(order.getCartProducts(), 100, 100);

		theModel.addAttribute("order", order);

		return "fullOrder";
	}

	@GetMapping("/showAddOrEditPaymentMethod")
	public String showAddOrEditPaymentMethod(Model theModel, Principal principal, HttpSession session) {

		int userId = (int) session.getAttribute("userId");

		User user = userService.getUserById(userId);

		List<CreditCard> creditCards = creditCardService.getCreditCardsByUserId(userId);

		if (creditCards.isEmpty()) {
			theModel.addAttribute("noCreditCards", true);
			theModel.addAttribute("creditCard", new CreditCard());
			theModel.addAttribute("address", user.getUserDetails().getAddress());
			theModel.addAttribute("updateCreditCard", false);

			return "addOrEditPaymentMethod";
		} else {
			theModel.addAttribute("creditCardsList", creditCards);

			return "creditCardsList";
		}

	}

	@GetMapping("/editCreditCard")
	public String editCreditCard(Model theModel, @RequestParam("creditCardId") int creditCardId) {

		CreditCard creditCard = creditCardService.getCreditCardById(creditCardId);

		theModel.addAttribute("creditCard", creditCard);
		theModel.addAttribute("address", creditCard.getAddress());
		theModel.addAttribute("isItDefault", creditCard.isItDefault());
		theModel.addAttribute("updateCreditCard", true);

		return "addOrEditPaymentMethod";
	}

	@GetMapping("/removeCreditCard")
	public String removeCreditCard(Model theModel, @RequestParam("creditCardId") int creditCardId) {

		creditCardService.removeCreditCardById(creditCardId);

		return "redirect:/account/showAddOrEditPaymentMethod";
	}

	@PostMapping("/savePaymentMethod")
	public String savePaymentMethod(Model theModel, @RequestParam Map<String, String> parameters,
			@RequestParam(value = "setDefaultAddress", required = false) boolean setDefaultAddress,
			@RequestParam(value = "setAsDefaultCreditCard", required = false) boolean setAsDefaultCreditCard,
			@ModelAttribute("creditCard") CreditCard creditCard, Principal principal) {
		
		parameters.put("setDefaultAddress", String.valueOf(setDefaultAddress));
		parameters.put("setAsDefaultCreditCard", String.valueOf(setAsDefaultCreditCard));
		
		creditCardOperations.change(creditCard, parameters);

		return "redirect:/account/showAddOrEditPaymentMethod";
	}

}
