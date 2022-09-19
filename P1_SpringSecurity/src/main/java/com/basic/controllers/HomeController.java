package com.basic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/home")
	public String getHome()
	{
		return "This is a home controller for check";
	}
	
	
	@GetMapping("/login")
	public String getLogin()
	{
		return "This is a Login URL Request check";
	}
	
	
	@GetMapping("/register")
	public String getRegister()
	{
		return "This is a Register URL Request check";
	}

}
