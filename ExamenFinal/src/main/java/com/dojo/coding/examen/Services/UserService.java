package com.dojo.coding.examen.Services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.coding.examen.models.User;
import com.dojo.coding.examen.repositories.UserRepository;



@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	public User registerUser(User user) {
	    // Verifica si el correo electrónico ya existe
	    User existingUser = userRepository.findByEmail(user.getEmail());
	    if (existingUser != null) {
	        // El correo electrónico ya está en uso
	        return null;
	    }

	    // El correo electrónico no está en uso, procede a crear el usuario
	    String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
	    user.setPassword(hashed);
	    return userRepository.save(user);
	}


	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findUserById(Long id) {
		Optional<User> u = userRepository.findById(id);
		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

	public boolean authenticateUser(String email, String password) {
	    User user = userRepository.findByEmail(email);
	    if (user == null) {
	        // No se encontró ningún usuario con el correo electrónico dado
	        return false;
	    }

	    // Verificar la contraseña utilizando BCrypt
	    if (BCrypt.checkpw(password, user.getPassword())) {
	        // La contraseña es válida
	        return true;
	    } else {
	        // La contraseña no es válida
	        return false;
	    }
	}

	
}
