package com.dojo.coding.proyect.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.coding.proyect.models.User;
import com.dojo.coding.proyect.repositories.PublicationRepository;
import com.dojo.coding.proyect.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Service
public class PublicationService {
	

	private final UserRepository userRepository;

	
	public PublicationService( UserRepository userRepository ) {
		this.userRepository = userRepository;
	}
	@Autowired PublicationRepository publicationRepository;
	public void incrementLikes(Long id) {
        publicationRepository.incrementLikes(id);
    }
	public User registerUser(User user) {
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		return userRepository.save(user);
	}
	public boolean checkLogin(String email,String password) {
		User user = userRepository.findByEmail(email);
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
		return userRepository.findByEmail(email);
	}
}
