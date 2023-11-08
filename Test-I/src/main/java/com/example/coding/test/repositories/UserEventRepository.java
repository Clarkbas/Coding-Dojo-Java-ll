package com.example.coding.test.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coding.test.models.Event;
import com.example.coding.test.models.User;
import com.example.coding.test.models.UserEvent;

@Repository
public interface UserEventRepository extends CrudRepository<UserEvent,Long> {
	
	List<UserEvent> findByEventContains(Event event);
	UserEvent findByEventAndUser(Event event, User user);

}
