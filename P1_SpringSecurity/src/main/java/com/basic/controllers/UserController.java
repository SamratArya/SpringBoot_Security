package com.basic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.entities.User;
import com.basic.services.UserServices;

@RestController
//@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServices userServices;

	// GET ALL THE USER DATA
	@GetMapping("/user")
	public List<User> getAllUser() {
		return this.userServices.getAllData();
	}

	// GET THE SPECIFIC DATA OF THE USER
	@GetMapping("/user/{username}")
	public User getSpecific(@PathVariable("username") String username) {
		User u1 = this.userServices.getBySpecific(username);
		return u1;
	}

	@PostMapping("/user")
	public User addData(@RequestBody User user) {
		User u1 = this.userServices.addData(user);
		return u1;
	}

}
