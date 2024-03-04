package com.openclassrooms.projet3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.projet3.dto.UserDTO;
import com.openclassrooms.projet3.model.User;
import com.openclassrooms.projet3.repository.UserRepository;

import org.modelmapper.ModelMapper;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
    private ModelMapper modelMapper;
	
//	public Iterable<User> getUsers(){
//		return userRepository.findAll();
//	}
	
	public Optional<UserDTO> getUserById(Long id){
		return userRepository.findById(id).map(user -> modelMapper.map(user, UserDTO.class));
	}


}
