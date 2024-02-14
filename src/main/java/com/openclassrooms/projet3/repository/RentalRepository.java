package com.openclassrooms.projet3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.projet3.model.Rental;

@Repository
public interface RentalRepository extends CrudRepository<Rental, Long>{

	//pour mettre des requeste SQL custom
}
