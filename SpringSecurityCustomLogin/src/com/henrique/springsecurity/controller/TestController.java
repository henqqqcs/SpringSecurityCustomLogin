package com.henrique.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/payment/cart")
	public String cart() {
		return "cart";
	}
	
	@RequestMapping("/payment/login")
	public String cartLogin() {
		return "login";
	}

	@RequestMapping("/secured/home")
	public String securedHome() {
		return "secured/home";
	}

	@RequestMapping("/secured/edit")
	public String securedEdit() {
		return "secured/edit";
	}

	@RequestMapping("/secured/payment")
	public String securedTest() {
		return "secured/test";
	}

	@RequestMapping("/admin")
	public String adminHome() {
		return "admin/home";
	}

}
