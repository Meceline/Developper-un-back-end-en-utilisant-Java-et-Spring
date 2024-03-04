package com.openclassrooms.projet3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticatedController {
	
	@GetMapping("/me")
	public String getUser() {
		
		return "";
	}
}
