package com.JairoBurgos.Events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.Events.models.User;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {
	User findByEmail(String email);
}
