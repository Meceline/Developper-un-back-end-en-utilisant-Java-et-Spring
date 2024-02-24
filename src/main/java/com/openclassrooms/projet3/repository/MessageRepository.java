package com.openclassrooms.projet3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.projet3.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

}
