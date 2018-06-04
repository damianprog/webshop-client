package com.webshop.webapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.webshop.webapp.entity.ForbiddenAction;

@ControllerAdvice
public class ExceptionsController {

	@ExceptionHandler(ForbiddenAction.class)
	public String forbiddenAction(Model theModel) {

		return "forbiddenAction";
	}
	
}
