package com.basic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignInController {
	
	@GetMapping("/signin")
	public String getSingIn()
	{
		return "login.html";
	}

}
