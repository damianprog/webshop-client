package com.webshop.webapp.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.CreditCardService;
import com.webshop.webapp.entity.service.UserService;

@Component
public class PrepareOrCreateModelCreditCard {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
	private HttpSession session;
	
	public ModelMap prepareOrCreate() {

		int userId = (int) session.getAttribute("userId");

		User user = userService.getUserById(userId);

		CreditCard creditCard = creditCardService.getDefaultCreditCardByUserId(userId);

		ModelMap modelMap = new ModelMap();

		if (creditCard != null) {
			modelMap.addAttribute("creditCard", creditCard);
			modelMap.addAttribute("address", creditCard.getAddress());
		} else {
			modelMap.addAttribute("creditCard", new CreditCard());
			modelMap.addAttribute("address", user.getUserDetails().getAddress());
		}

		return modelMap;
	}

}
