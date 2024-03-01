package com.openclassrooms.projet3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.projet3.dto.RentalDTO;
import com.openclassrooms.projet3.model.Rental;
import com.openclassrooms.projet3.model.User;
import com.openclassrooms.projet3.repository.RentalRepository;


@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;
	
	public Iterable<RentalDTO> getRentals(){
		//Recoit rien, sort une list de DTO
		 Iterable<Rental> rentals = rentalRepository.findAll();
        List<RentalDTO> rentalDTOs = new ArrayList<>();
        for (Rental r : rentals) {
        	RentalDTO rentalDto = new RentalDTO();
        	rentalDto.setId(r.getId());
    		rentalDto.setName(r.getName());
    		rentalDto.setSurface(r.getSurface());
    		rentalDto.setPrice(r.getPrice());
    		rentalDto.setPicture(r.getPicture());
    		rentalDto.setDescription(r.getDescription());
    		rentalDto.setOwner_id(r.getOwner().getId());
    		rentalDto.setCreated_at(r.getCreated_at());
    		rentalDto.setUpdated_at(r.getUpdated_at());
            rentalDTOs.add(rentalDto);
        }
	       return rentalDTOs;
//		return rentalRepository.findAll();	
	}
	
	
	
	public RentalDTO getRental(Long id){
		RentalDTO rentalDto = new RentalDTO();
		
		Rental r = rentalRepository.findById(id).get();
		rentalDto.setId(r.getId());
		rentalDto.setName(r.getName());
		rentalDto.setSurface(r.getSurface());
		rentalDto.setPrice(r.getPrice());
		rentalDto.setPicture(r.getPicture());
		rentalDto.setDescription(r.getDescription());
		rentalDto.setOwner_id(r.getOwner().getId());
		rentalDto.setCreated_at(r.getCreated_at());
		rentalDto.setUpdated_at(r.getUpdated_at());
		
		return rentalDto;
	}
	
	
	public Rental createRental(Rental rental) {
		Rental createdRental = rentalRepository.save(rental);
		return createdRental;
	}
	
	public Rental updateRental(Rental rental) {
		Rental savedRental = rentalRepository.save(rental);
		return savedRental;
	}

}
