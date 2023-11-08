package com.example.coding.ListStudentsII.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coding.ListStudentsII.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

	List<Contact> findAll();


}
