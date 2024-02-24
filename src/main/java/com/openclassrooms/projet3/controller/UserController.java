package com.openclassrooms.projet3.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.projet3.model.User;
import com.openclassrooms.projet3.service.UserService;

import com.openclassrooms.projet3.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public Iterable<User> getUser(){
		return userService.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO>  getUser(@PathVariable("id") final Long id) {
		Optional<UserDTO> user = userService.getUser(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
}
