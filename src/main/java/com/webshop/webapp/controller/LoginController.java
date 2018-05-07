package com.webshop.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webshop.webapp.entity.User;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(@RequestParam(value="error",required=false) Boolean error,Model theModel) {
		
		theModel.addAttribute("user",new User());
		
		if((error != null)&&(error == true))
			theModel.addAttribute("error",true);
		
		return "login";
	}
	
}
