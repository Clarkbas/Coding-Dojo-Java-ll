package com.dojo.coding.proyect.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.coding.proyect.models.User;
import com.dojo.coding.proyect.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepositories;

	public boolean authenticateUser(String email, String password) {
		User user = userRepositories.findByEmail(email);
		if (user == null) {
			return false;
		} else {
			if (BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
	public User findByEmail(String email) {
		return userRepositories.findByEmail(email); 
	//busca y devuelve un usuario por su dirección de correo electrónico desde el repositorio de usuarios.
	}
	
	public User findUserById(Long id) {
		Optional<User> user = userRepositories.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}/*función busca y devuelve un usuario por su ID desde el repositorio de usuarios. 
		Si se encuentra, devuelve el usuario; de lo contrario, retorna null.*/
	}
	public User findById(Long userId) {
	    Optional<User> user = userRepositories.findById(userId);
	    if (user.isPresent()) {
	        return user.get();
	    } else {
	        return null;
	    }
	}

	public void save(User user) {
	    userRepositories.save(user);
	}

}
