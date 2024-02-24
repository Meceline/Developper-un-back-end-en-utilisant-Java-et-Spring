package com.openclassrooms.projet3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.projet3.model.Message;
import com.openclassrooms.projet3.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	public Message createMessage(Message message) {
		//recoit dto, transforme en entity, save
		Message createdMessage =  messageRepository.save(message);
		return createdMessage;
	}
	
}
