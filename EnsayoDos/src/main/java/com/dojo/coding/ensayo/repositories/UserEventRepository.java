package com.dojo.coding.ensayo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.coding.ensayo.models.Event;
import com.dojo.coding.ensayo.models.User;
import com.dojo.coding.ensayo.models.UserEvent;

@Repository
public interface UserEventRepository extends CrudRepository<UserEvent,Long> {
	
	List<UserEvent> findByEventContains(Event event);
	UserEvent findByEventAndUser(Event event, User user);

}
