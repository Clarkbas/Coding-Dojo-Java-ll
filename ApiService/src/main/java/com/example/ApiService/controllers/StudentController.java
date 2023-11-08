package com.example.ApiService.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.License;
import com.codingdojo.mvc.models.Person;
import com.codingdojo.mvc.services.LicenseService;
import com.codingdojo.mvc.services.UserService;
import com.example.ApiService.Services.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/persons/new")
	public String newPerson(@Valid @ModelAttribute("person") Person person) {
		return "/views/newPerson.jsp";
	}


	@RequestMapping(value = "/licenses/new", method = RequestMethod.POST)
	public String newLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
	    if (result.hasErrors()) {
	        return "/views/newLicense.jsp";
	    }

	    // Verificar si hay personas en la base de datos
	    List<Person> persons = userService.findAll();
	    if (persons.isEmpty()) {
	        // Si no hay personas, asignar el número de licencia "000001"
	        license.setNumber("000001");
	    } else {
	        // Si hay personas, obtener la última licencia y generar el siguiente número
	        License lastLicense = licenseService.findLastLicense();
	        if (lastLicense != null) {
	            int nextNumber = Integer.parseInt(lastLicense.getNumber()) + 1;
	            String nextLicenseNumber = String.format("%06d", nextNumber); // Rellena con ceros a la izquierda
	            license.setNumber(nextLicenseNumber);
	        } else {
	            // Si no hay última licencia (es la primera licencia en la base de datos), asignar el número "000001"
	            license.setNumber("000001");
	        }
	    }

	    licenseService.saveLicense(license);
	    return "redirect:/licenses/new";
	}

	
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("user") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "/views/newPerson.jsp";
		}
		userService.create(person);
		return "redirect:/persons/new";
	}
	

	
	@RequestMapping("/licenses/new")
	public String newLicense(Model model,@Valid @ModelAttribute("license") License license) {
		List<Person> persons = userService.obtenerPersonasSinLicencia();
//		List<Person> persons = userService.findAll();
		model.addAttribute("persons", persons);
		return "/views/newLicense.jsp";
	}
	

    @RequestMapping("/persons/{id}")
    public String showPersonWithLicense(@PathVariable("id") Long personId, Model model) {
        Person person = userService.findPersonById(personId);
        if (person == null) {
            return "redirect:/persons/new";
        }

        License license = licenseService.findLicenseByPersonId(personId);
        if (license == null) {
            return "redirect:/persons/new";
        }

        model.addAttribute("person", person);
        model.addAttribute("license", license);
        return "/views/TablaRegistro.jsp";
    }
