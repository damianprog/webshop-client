package com.webshop.webapp.utils;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.CreditCardService;
import com.webshop.webapp.entity.service.UserService;

@Component
public class AddOrEditPaymentModelInitilizer {

	@Autowired
	private UserService userService;

	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
	private HttpSession session;
	
	private ModelMap modelMap;
	
	private User user;
	
	private String view;
	
	private List<CreditCard> creditCards;
	
	public void initializeModelAndViewString() {
		
		int userId = (int) session.getAttribute("userId");

		this.user = userService.getUserById(userId);

		creditCards = creditCardService.getCreditCardsByUserId(userId);
		
		modelMap = new ModelMap();
		
		if (creditCards.isEmpty()) {
			initializeNewPaymentMethod();

			view = "addOrEditPaymentMethod";
		} else {
			initializeCardsList(creditCards);
			view = "creditCardsList";
		
	}
	
}

	private void initializeCardsList(List<CreditCard> creditCards) {
		modelMap.addAttribute("creditCardsList", creditCards);
	}

	private void initializeNewPaymentMethod() {
		modelMap.addAttribute("noCreditCards", true);
		modelMap.addAttribute("creditCard", new CreditCard());
		modelMap.addAttribute("address", user.getUserDetails().getAddress());
		modelMap.addAttribute("updateCreditCard", false);
	}
	
	public ModelMap getModelMap() {
		return modelMap;
	}
	
	public String getViewString() {
		return view;
	}
	
}