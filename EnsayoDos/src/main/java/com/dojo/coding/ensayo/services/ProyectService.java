package com.dojo.coding.ensayo.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.dojo.coding.ensayo.models.Comment;
import com.dojo.coding.ensayo.models.Event;
import com.dojo.coding.ensayo.models.User;
import com.dojo.coding.ensayo.models.UserEvent;
import com.dojo.coding.ensayo.repositories.CommentRepository;
import com.dojo.coding.ensayo.repositories.EventRepository;
import com.dojo.coding.ensayo.repositories.UserEventRepository;
import com.dojo.coding.ensayo.repositories.UserRepository;

@Service
public class ProyectService {
	
	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	private final EventRepository eventRepository;
	private final UserEventRepository userEventRepository;
	
	public ProyectService(
			CommentRepository commentRepository, 
			UserRepository userRepository, 
			EventRepository eventRepository,
			UserEventRepository userEventRepository) {
		
		this.commentRepository = commentRepository;
		this.userRepository = userRepository;
		this.eventRepository = eventRepository;
		this.userEventRepository = userEventRepository;
	}
	
	public User registerUser(User user) {
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		return userRepository.save(user);
	}
	
	public boolean checkLogin(String email, String password) {
		User user = userRepository.findByEmail(email);
		if(user == null) {
			return false;
		}else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}else{
				return false;
			}
		}
	}
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}
	public Event createEvent(Event event, Long id) {
		event.setUser(getUserById(id));
		return eventRepository.save(event);
	}
	
	public Event eventById(Long id) {
		if(eventRepository.findById(id) != null) {
			return eventRepository.findById(id).get();
		}
		else {
			return null;
		}
	}
	
	public void deleteEventById(Long id) {
		eventRepository.deleteById(id);
	}
	
	public void updateEvent(Event event) {
		eventRepository.save(event);
	
	}
	
	public UserEvent userJoinEvent(UserEvent join) {
		return userEventRepository.save(join);
	}
	
	public Iterable<UserEvent> joinedEvents() {
		return userEventRepository.findAll();
	}
	
	public void cancelJoin(UserEvent userEvent) {
		userEventRepository.delete(userEvent);
	}
	
	public UserEvent findJoinedEvent(Event event, User user) {
		return userEventRepository.findByEventAndUser(event, user);
	}
	
	public Comment addComment(Comment comment) {
		return commentRepository.save(comment);
	}

}
