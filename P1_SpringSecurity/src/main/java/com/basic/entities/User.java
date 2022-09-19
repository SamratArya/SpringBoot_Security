package com.basic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "username")
	String username;
	@Column(name = "password")
	String password;
	@Column(name = "emailId")
	String emailId;
	@Column(name = "role")
	String role;
 
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String emailId) {
		super();
		this.username = username;
		this.password = password;
		this.emailId = emailId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", emailId=" + emailId + ", role=" + role
				+ "]";
	}



}
