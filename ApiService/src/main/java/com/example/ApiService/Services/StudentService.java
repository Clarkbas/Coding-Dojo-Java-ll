package com.example.ApiService.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.License;
import com.codingdojo.mvc.models.Person;
import com.codingdojo.mvc.repositories.UserRepository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Service
public class StudentService {
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
