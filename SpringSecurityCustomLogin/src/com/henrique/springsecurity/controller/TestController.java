package com.henrique.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	// Spring Security see this:
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "emailJaCadastrado", required = false) String emailJaCadastrado, 
			@RequestParam(value = "denied", required = false) String denied,
			ModelMap map) {

		if (error != null) {
			map.put("error", "Ops! Esse usuário não foi encontrado, verique seu email e senha.");
		}

		if (logout != null) {
			map.put("msg", "Você fez logout.");
		}
		
		if (denied != null) {
			map.put("denied", "Acesso negado.");
		}
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
