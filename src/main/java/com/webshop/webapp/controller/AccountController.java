package com.webshop.webapp.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webshop.webapp.entity.UserDetails;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.utils.service.SaveService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	UserService userService;
	
	@Autowired
	SaveService saveService;
	
	@GetMapping("/showShippingAddress")
	public String shippingAddressPage(Model theModel,Principal principal) {
		
		theModel.addAttribute("userDetails",userService.getUserByUserName(principal.getName()).getUserDetails());
		
		return "shippingAddress";
	}
	
	@GetMapping("/showAccount")
	public String showAccount(Model theModel,Principal principal) {
		
		
		return "account";
	}
	
	@PostMapping("/saveShippingAddress")
	public String saveShippingAddresses(Model theModel,Principal principal,@ModelAttribute("userDetails") UserDetails userDetails) {
		
		saveService.saveUserDetails(userDetails, principal.getName());
		
		return "account";
	}
	
}
