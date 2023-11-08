package com.dojo.coding.proyect.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dojo.coding.proyect.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}
