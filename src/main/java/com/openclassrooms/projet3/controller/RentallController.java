package com.openclassrooms.projet3.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.projet3.model.Rental;
import com.openclassrooms.projet3.model.User;
import com.openclassrooms.projet3.service.RentalService;

@RestController
@RequestMapping("/api")
public class RentallController {

	@Autowired
	private RentalService rentalService;
	
	@GetMapping("/rentals")
	public Iterable<Rental> getRentals(){
		return rentalService.getRentals();
	}
	@GetMapping("/rentals/{id}")
	public Rental getRental(@PathVariable("id") final Long id) {
		Optional<Rental> rental = rentalService.getRental(id);
		if(rental.isPresent()) {
			return rental.get();
		}else{
			return null;
		}
	}
}
