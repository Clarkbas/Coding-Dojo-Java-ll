package com.example.coding.test.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.coding.test.models.Comment;
import com.example.coding.test.models.Event;
import com.example.coding.test.models.User;
import com.example.coding.test.models.UserEvent;
import com.example.coding.test.repositories.CommentRepository;
import com.example.coding.test.repositories.EventRepository;
import com.example.coding.test.repositories.UserEventRepository;
import com.example.coding.test.repositories.UserRepository;

@Service
public class ProjectService {
	
	private final CommentRepository cR;
	private final UserRepository  uR;
	private final EventRepository  eR;
	private final UserEventRepository  uER;
	
	public ProjectService(CommentRepository  cR, UserRepository  uR, EventRepository  eR, UserEventRepository  uER) {
		this.cR = cR;
		this.uR = uR;
		this.eR = eR;
		this.uER = uER;
	}
	
	public User registerUser(User user) {
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		return uR.save(user);
	}
	
	public boolean checkLogin(String email,String password) {
		User user = uR.findByEmail(email);
		if(user == null) {
			return false;
		}
		else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public User findByEmail(String email) {
		return uR.findByEmail(email);
	}
	
	public User getUserById(Long id) {
		return uR.findById(id).get();
	}
	
	
	public Event createEvent(Event event, Long id) {
		event.setUser(getUserById(id));
		return eR.save(event);
	}
	
	public List<Event> sameStateEvents(String state){
		return eR.findByStateContains(state);
	}
	
	public List<Event> outSideStateEvents(String state){
		return eR.findByStateNotContains(state);
	}
	
	public Event eventById(Long id) {
		if(eR.findById(id) != null) {
			return eR.findById(id).get();
		}
		else {
			return null;
		}
	}
	
	public void deleteEventById(Long id) {
		eR.deleteById(id);
	}
	
	public void updateEvent(Event event) {
		eR.save(event);
	
	}
	
	public UserEvent userJoinEvent(UserEvent join) {
		return uER.save(join);
	}
	
	public Iterable<UserEvent> joinedEvents() {
		return uER.findAll();
	}
	
	public void cancelJoin(UserEvent userEvent) {
		uER.delete(userEvent);
	}
	
	public UserEvent findJoinedEvent(Event event, User user) {
		return uER.findByEventAndUser(event, user);
	}
	
	public Comment addComment(Comment comment) {
		return cR.save(comment);
	}


	
	
	
}
