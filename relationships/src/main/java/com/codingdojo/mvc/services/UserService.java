package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Person;
import com.codingdojo.mvc.repositories.UserRepository;

@Service
public class UserService {
	//Agregando el tag al repositorio como una dependencia
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<Person> findAll() {
		return userRepository.findAll();
	}
	
	public List<Person> obtenerPersonasSinLicencia() {
		return userRepository.findByLicenseIsNull();
	}
	
	public Person create(Person user) {
		return userRepository.save(user);
	}
	
	public Person findUser(Long id) {
		Optional<Person> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}

	public Person updateUser(Person user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

    public Person findPersonById(Long personId) {
        Optional<Person> optionalPerson = userRepository.findById(personId);
        return optionalPerson.orElse(null);
    }
}
