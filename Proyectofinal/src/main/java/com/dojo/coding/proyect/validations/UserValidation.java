package com.dojo.coding.proyect.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dojo.coding.proyect.models.User;
import com.dojo.coding.proyect.services.PublicationService;

@Component
public class UserValidation implements Validator {
	private PublicationService publicationService;
	
	public UserValidation(PublicationService publicationService) {
		this.publicationService = publicationService;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		
		
	}

}