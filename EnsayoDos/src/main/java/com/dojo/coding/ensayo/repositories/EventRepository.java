package com.dojo.coding.ensayo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.coding.ensayo.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
	

}