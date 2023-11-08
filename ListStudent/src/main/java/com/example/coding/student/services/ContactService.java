package com.example.coding.student.services;

import org.springframework.stereotype.Service;

import com.example.coding.student.models.Contact;
import com.example.coding.student.repositories.ContactRepository;

@Service
public class ContactService {

	private ContactRepository contactRepository;

	public ContactService(ContactRepository contactRepository) { 
		this.contactRepository = contactRepository;
	}

	public Contact saveContact(Contact newContact) {
		return contactRepository.save(newContact);
	}
}
