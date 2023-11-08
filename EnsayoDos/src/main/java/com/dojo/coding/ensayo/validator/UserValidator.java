package com.dojo.coding.ensayo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dojo.coding.ensayo.models.User;
import com.dojo.coding.ensayo.services.ProyectService;

@Component
public class UserValidator implements Validator {
	private ProyectService proyectService;
	
	public UserValidator(ProyectService proyectService) {
		this.proyectService = proyectService;
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
