package com.example.coding.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.coding.countries.Repositories.CountryRepository;
import com.example.coding.countries.Services.ApiService;
import com.example.coding.countries.models.Country;



@Controller
public class HomeController {
	private ApiService ApiService;
	
	
	public HomeController(ApiService  apiService) {
		this.ApiService = apiService;
	}


	@RequestMapping("/")
	public String index(Model model) {
		List<Object[]> question1 = ApiService.question1("slovene");
		model.addAttribute("list",question1);
	
		return "views/country.jsp";
	}
	
	@GetMapping("/test")
	public void test() {
	    List<Object[]> table = CountryRepository.countrySpeaksLanguageByPercentage_4();

	    for(Object[] row : table) {
	        Country c = (Country)row[0];
	        System.out.print("- "+ c.getName());
	    }
	}
}
