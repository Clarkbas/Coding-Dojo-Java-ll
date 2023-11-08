package com.dojo.coding.ensayo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dojo.coding.ensayo.models.User;
import com.dojo.coding.ensayo.services.ProyectService;
import com.dojo.coding.ensayo.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProyectController {
	
	private final ProyectService proyectService;
	private final UserValidator userValidator;
	
	public ProyectController(ProyectService proyectService, UserValidator userValidator) {
		this.proyectService = proyectService;
		this.userValidator = userValidator;
	}
	
	
	@GetMapping("/")
	public String loginRegister(@ModelAttribute("index")User register, HttpSession session) {
		if(session.isNew()) {
			session.setAttribute("login", false);
		}
		return "views/index.jsp";
	}
	
	@PostMapping("/register")
	public String registerProcess(@Valid @ModelAttribute("index")User userRegister, BindingResult result, RedirectAttributes redirectAttributes) {
		userValidator.validate(userRegister, result);
		if(result.hasErrors()) {
			return"views/index.jsp";
		}else {
			proyectService.registerUser(userRegister);
			redirectAttributes.addFlashAttribute("success", "<p class=\"alert alert-success\" role=\"alert\"> Registration Successful! You may now Log in. </p>");
			return "redirect:/";
		}
	}
	
	@PostMapping("/Login")
	public String loginProcess(@RequestParam("email")String email,@RequestParam("password")String password,HttpSession session,RedirectAttributes redirectAttributes) {
		if(proyectService.checkLogin(email, password) == false) {
			redirectAttributes.addFlashAttribute("error","<p class=\"alert alert-danger text-center\" role=\"alert\"> Invalid Credentials </p>");
			return "redirect:/";
		}
		else {
			session.setAttribute("login", true);
			session.setAttribute("user",proyectService.findByEmail(email).getId());
			return"redirect:/home";
			
		}
	}


}
