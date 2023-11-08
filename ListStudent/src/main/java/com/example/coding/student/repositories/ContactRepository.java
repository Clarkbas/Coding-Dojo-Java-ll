package com.example.coding.student.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.coding.student.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

	List<Contact> findAll();
}
