package com.JairoBurgos.Events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.Events.models.Event;
import com.JairoBurgos.Events.models.User;
import com.JairoBurgos.Events.models.UserEvent;

@Repository
public interface UserEventRepo extends CrudRepository<UserEvent,Long> {
	List<UserEvent> findByEventContains(Event event);
	UserEvent findByEventAndUser(Event event, User user);
	
}
