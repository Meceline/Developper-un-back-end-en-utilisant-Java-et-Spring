package com.openclassrooms.projet3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.projet3.dto.MessageRequestDTO;
import com.openclassrooms.projet3.dto.MessageResponseDTO;
import com.openclassrooms.projet3.service.MessageService;

@RestController
@RequestMapping("/api")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@PostMapping("/message")
	public MessageResponseDTO createMessage(@RequestBody MessageRequestDTO message) {

		messageService.createMessage(message);	
		MessageResponseDTO response = new MessageResponseDTO();
		response.setMessage("Message send with success");
		return response;
	}
}
