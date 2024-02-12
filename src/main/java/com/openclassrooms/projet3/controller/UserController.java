package com.openclassrooms.projet3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.projet3.model.User;
import com.openclassrooms.projet3.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public Iterable<User> getUser(){
		return userService.getUsers();
	}
	
}
