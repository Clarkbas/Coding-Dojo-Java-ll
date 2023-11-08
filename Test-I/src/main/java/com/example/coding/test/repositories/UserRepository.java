package com.example.coding.test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coding.test.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	User findByEmail(String email);
}
