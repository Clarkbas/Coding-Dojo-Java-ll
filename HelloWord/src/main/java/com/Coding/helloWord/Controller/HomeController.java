package com.Coding.helloWord.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Coding.helloWord.model.User;



@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@PostMapping("/code")
	public String userRegistration(@ModelAttribute User user, Model model) {
	    System.out.println(user.toString());
	    //validate
	    System.out.println(user.getFname());
	    System.out.println(user.getLname());
	    System.out.println(user.getFecha());
	    System.out.println(user.getEmail());
	    model.addAttribute("firstname", user.getFname());
	    model.addAttribute("lastname", user.getLname());
	    return "code";
	}

}
