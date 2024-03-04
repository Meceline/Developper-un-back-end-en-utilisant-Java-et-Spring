package com.openclassrooms.projet3.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.openclassrooms.projet3.model.Rental;
import com.openclassrooms.projet3.model.User;

@Repository
public interface RentalRepository extends CrudRepository<Rental, Long>{

	@Query("SELECT r.owner FROM Rental r WHERE r.id = :rentalId")
    public User findUserByRentalId(@Param("rentalId") Long rentalId);
	
	@Query("SELECT r.created_at FROM Rental r WHERE r.id = :rentalId")
    public Date findCreatedDateByRentalId(@Param("rentalId") Long rentalId);
}
