package com.openclassrooms.projet3.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.openclassrooms.projet3.dto.MessageResponseDTO;

import com.openclassrooms.projet3.dto.RentalDTO;
import com.openclassrooms.projet3.model.Rental;
import com.openclassrooms.projet3.model.User;

import com.openclassrooms.projet3.repository.RentalRepository;
import com.openclassrooms.projet3.service.RentalService;

@RestController
@RequestMapping("/api")
public class RentalController {

	@Autowired
	private RentalService rentalService;
	
	@GetMapping("/rentals")
	public Iterable<RentalDTO> getRentals(){
		return rentalService.getRentals();
	}
	
	@GetMapping("/rentals/{id}")
	public RentalDTO getRental(@PathVariable("id") final String id_string) {
		long id = Long.parseLong(id_string);
		RentalDTO rental = rentalService.getRental(id);
		return rental;
	}
	
	
	
	@PostMapping("/rental")
	public MessageResponseDTO createRetal(@RequestBody Rental rental) {
		//TODO Récupérer le user courant  - session ?
		rentalService.createRental(rental);	
		
		MessageResponseDTO response = new MessageResponseDTO();
		response.setMessage("Rental created !");
		return response;
	}
		
	
	@PutMapping("/rental")
	public MessageResponseDTO updateRental(@RequestBody RentalDTO rentalDto) {

		rentalService.updateRental(rentalDto);	
		
		MessageResponseDTO response = new MessageResponseDTO();
		response.setMessage("Rental updated !");
		return response;	
	}
}
