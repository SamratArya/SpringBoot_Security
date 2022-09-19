package com.basic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.entities.User;
import com.basic.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	UserRepository uRepository;

	// Get all the data of user
	public List<User> getAllData() {
		return this.uRepository.findAll();
	}

	// Get the data of user by specific fields
	public User getBySpecific(String username) {
		// Here it will filter and check the specific username which is there in the
		// list
		return this.uRepository.findById(username).stream().filter((user) -> user.getUsername().equals(username)).findAny().get();
	}

	// Add or insert the data
	public User addData(User user) {
		this.uRepository.save(user);
		return user;
	}
	
	
	

}
