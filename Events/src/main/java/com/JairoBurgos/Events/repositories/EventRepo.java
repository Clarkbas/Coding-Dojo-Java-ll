package com.JairoBurgos.Events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.Events.models.Event;

@Repository
public interface EventRepo extends CrudRepository<Event,Long> {
	List<Event> findByStateContains(String state);
	List<Event> findByStateNotContains(String state);

}
