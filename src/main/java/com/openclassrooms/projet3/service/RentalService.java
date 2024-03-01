package com.openclassrooms.projet3.service;

import java.util.ArrayList;
import java.util.Date;
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
	
	
	public void createRental(Rental r) {
		//recoit un rental, sort rien, le message est créé dans le controller
		Rental rental = new Rental();
        rental.setName(r.getName());
        rental.setSurface(r.getSurface());
        rental.setPrice(r.getPrice());
        rental.setPicture(r.getPicture());
        rental.setDescription(r.getDescription());
        rental.setCreated_at(new Date());
        rental.setUpdated_at(new Date());
        
        User u = new User();
        u.setId((long) 1);
        rental.setOwner(u);
        
		rentalRepository.save(rental);
	}
	
	public void updateRental(Rental r) {
		
		//recoit un rental, sort rien, le message est créé dans le controller
		Rental rental = new Rental();
		rental.setId(r.getId());
        rental.setName(r.getName());
        rental.setSurface(r.getSurface());
        rental.setPrice(r.getPrice());
        rental.setPicture(r.getPicture());
        rental.setDescription(r.getDescription());
        rental.setCreated_at(r.getCreated_at());
        rental.setUpdated_at(new Date());
        
        User u = new User();
        u.setId((long) 1);
        rental.setOwner(u);
        
		rentalRepository.save(rental);
	}

}
