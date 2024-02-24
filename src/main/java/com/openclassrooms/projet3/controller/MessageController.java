package com.openclassrooms.projet3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.projet3.model.Message;
import com.openclassrooms.projet3.service.MessageService;

@RestController
@RequestMapping("/api")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@PostMapping("/message")
	public Message createMessage(@RequestBody Message message) { //changer type recu
		return messageService.createMessage(message);	
	}
}
