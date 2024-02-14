package com.openclassrooms.projet3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.projet3.model.User;
import com.openclassrooms.projet3.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public Iterable<User> getUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUser(Long id){
		return userRepository.findById(id);
	}

}
