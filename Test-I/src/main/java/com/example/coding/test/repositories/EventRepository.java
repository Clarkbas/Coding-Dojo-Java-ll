package com.example.coding.test.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coding.test.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
	
	List<Event> findByStateContains(String state);
	List<Event> findByStateNotContains(String state);

}
