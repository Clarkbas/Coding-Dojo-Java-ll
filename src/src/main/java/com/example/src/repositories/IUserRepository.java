package com.example.src.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.src.models.UserModel;

@Repository // Es una clase que permite hacer Qeris a una base datos
public interface IUserRepository extends JpaRepository<UserModel, Long> {
	
	

}
