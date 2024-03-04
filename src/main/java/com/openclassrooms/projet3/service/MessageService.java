package com.openclassrooms.projet3.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.projet3.dto.MessageRequestDTO;
import com.openclassrooms.projet3.model.Message;
import com.openclassrooms.projet3.model.Rental;
import com.openclassrooms.projet3.repository.MessageRepository;
import com.openclassrooms.projet3.repository.RentalRepository;
import com.openclassrooms.projet3.repository.UserRepository;
import com.openclassrooms.projet3.model.User;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RentalRepository rentalRepository;
	
		
	public void createMessage(MessageRequestDTO message) {
		//recoit dto, transforme en entity, save
		Message entity = new Message();
		
		entity.setMessage(message.getMessage());
		User user = userRepository.findById(message.getUser_id()).get();
		entity.setUser(user);
				
		Rental rental = rentalRepository.findById(message.getRental_id()).get();
		entity.setRental(rental);
		
		entity.setCreated_at(new Date());
		entity.setUpdated_at(new Date());
		messageRepository.save(entity);
	}
	
}
