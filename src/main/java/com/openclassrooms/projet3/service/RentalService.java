package com.openclassrooms.projet3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.projet3.model.Rental;
import com.openclassrooms.projet3.model.User;
import com.openclassrooms.projet3.repository.RentalRepository;


@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;
	
	public Iterable<Rental> getRentals(){
		return rentalRepository.findAll()
;	}
	
	public Optional<Rental> getRental(Long id){
		return rentalRepository.findById(id);
	}
	
	public Rental saveRental(Rental rental) {
		Rental savedRental = rentalRepository.save(rental);
		return savedRental;
	}
	
	public Rental updateRental(Rental rental) {
		Rental savedRental = rentalRepository.save(rental);
		return savedRental;
	}
}
