package com.openclassrooms.projet3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.projet3.model.User;
import com.openclassrooms.projet3.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//la methode peut retourner un User si il y en a un ou un Optionnal vide si y en a pas
	public Optional<User> getUser(final Long id){
		return userRepository.findById(id);
	}
	
	
	public Iterable<User> getUsers(){
		return userRepository.findAll();
	}

}
