package com.example.EncuestaDelDojo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.EncuestaDelDojo.model.User;

@Controller
public class homeController {
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@PostMapping("/register")
	public String userRegistration(@ModelAttribute User user, Model model) {
		System.out.println(user.toString());
		// validate 
		System.out.println(user.getFname());
		System.out.println(user.getLname());
		System.out.println(user.getDob());
		System.out.println(user.getEmail());
		System.out.println(user.getLanguage());
		System.out.println(user.getLocation());
		System.out.println(user.getComentario());
		model.addAttribute("firstname", user.getFname());
		model.addAttribute("lastname", user.getLname());
		model.addAttribute("Dob", user.getDob());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("Location", user.getLanguage());
		model.addAttribute("Language", user.getLocation());
		model.addAttribute("comentario", user.getComentario());
		return "Welcome";
	}


}
