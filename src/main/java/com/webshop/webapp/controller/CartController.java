package com.webshop.webapp.controller;

import java.security.Principal;
import java.time.LocalDate;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.Order;
import com.webshop.webapp.entity.OrderDetails;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.OrderService;
import com.webshop.webapp.entity.service.ProductService;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.utils.service.CartService;
import com.webshop.webapp.utils.service.SessionOrderService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private SessionOrderService sessionOrderService;

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

		return "redirect:/cart/showCart";

	}

	@GetMapping("/showCheckoutShippingType")
	public String showCheckoutShippingType(Model theModel, HttpSession session) {

		Cart cart = (Cart) session.getAttribute("cart");

		sessionOrderService.instantiateOrder();

		theModel.addAttribute("cartProducts", cart.getCartProducts());
		theModel.addAttribute("overallQuantity", cartService.countQuantityOfProductsInCart());
		theModel.addAttribute("overallPrice", cartService.countOverallCartProductsPrice());
		theModel.addAttribute("arrivesDate", LocalDate.now().plusDays(3));

		return "checkoutShippingType";

	}

	@GetMapping("/showCheckoutShippingAddress")
	public String showCheckoutShippingAddress(Model theModel, HttpSession session,
			@RequestParam("deliveryType") String deliveryType) {

		Cart cart = (Cart) session.getAttribute("cart");

		sessionOrderService.instantiateOrderDelivery(deliveryType);

		theModel.addAttribute("overallQuantity", cartService.countQuantityOfProductsInCart());
		theModel.addAttribute("overallPrice", cartService.countOverallCartProductsPrice());
		theModel.addAttribute("cartProducts", cart.getCartProducts());
		theModel.addAttribute("userCustomAddress", new Address());

		return "checkoutShippingAddress";

	}

	@GetMapping("/showCheckoutPaymentMethod")
	public String showPaymentMethod(Model theModel, Principal principal, HttpSession session) {

		Order order = (Order) session.getAttribute("order");
		User user = userService.getUserByUserName(principal.getName());

		order.setAddress(user.getUserDetails().getAddress());

		theModel.addAttribute("creditCard", new CreditCard());
		theModel.addAttribute("overallQuantity", cartService.countQuantityOfProductsInCart());
		theModel.addAttribute("overallPrice", cartService.countOverallCartProductsPrice());
		theModel.addAttribute("cartProducts", order.getCartProducts());
		theModel.addAttribute("address", order.getAddress());

		return "checkoutPaymentMethod";
	}

	@PostMapping("/addCustomAddressToOrder")
	public String addCustomAddressToOrder(Model theModel, @ModelAttribute("userCustomAddress") Address address,
			HttpSession session) {

		Order order = (Order) session.getAttribute("order");
		Address newAddress = orderService.saveAddressAndReturn(address);
		order.setAddress(newAddress);

		theModel.addAttribute("creditCard", new CreditCard());
		theModel.addAttribute("overallQuantity", cartService.countQuantityOfProductsInCart());
		theModel.addAttribute("overallPrice", cartService.countOverallCartProductsPrice());
		theModel.addAttribute("cartProducts", order.getCartProducts());
		theModel.addAttribute("address", order.getAddress());

		return "checkoutPaymentMethod";
	}

	@PostMapping("/saveOrder")
	public String saveOrder(@ModelAttribute("creditCard") CreditCard creditCard,
			@RequestParam Map<String, String> billingAddressMap,
			@RequestParam(value = "defaultAddress", required = false) boolean isItDefaultBillingAddress,
			@RequestParam(value = "isItDefaultCreditCard", required = false) boolean isItDefaultCreditCard, HttpSession session,
			Principal principal) {

		Order order = (Order) session.getAttribute("order");

		OrderDetails orderDetails = new OrderDetails(isItDefaultBillingAddress, isItDefaultCreditCard, billingAddressMap,
				creditCard);

		sessionOrderService.instantiateOrderDetails(orderDetails);

		orderService.saveOrder(order);

		return "main";
	}

}
