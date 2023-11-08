package com.example.DojoNinja.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DojoNinja.models.Dojo;
import com.example.DojoNinja.models.Ninja;
import com.example.DojoNinja.services.DojoService;
import com.example.DojoNinja.services.NinjaService;

@Controller
@RequestMapping("/")
public class DojoNinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;

	public DojoNinjaController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}

	@RequestMapping(value = "/dojos", method = { RequestMethod.GET, RequestMethod.POST })
	public String handleDojoForm(@RequestParam(required = false) String name) {
		if (name != null && !name.isEmpty()) {
			Dojo newDojo = new Dojo();
			newDojo.setName(name);
			dojoService.saveDojo(newDojo);
		}
		return "/views/Dojo.jsp"; // Redirige a la página principal o donde desees después de crear el dojo
	}

	@RequestMapping(value = "/ninjas", method = { RequestMethod.POST })
	public String createNinja(@ModelAttribute("ninjas") Ninja ninja) { // Acá tiene todo lo que lleva el ninja

		ninjaService.saveNinja(ninja);

		return "redirect:/ninjas/show";
	}

	@RequestMapping("/ninjas/show")
	public String showNinja(Model model, @ModelAttribute("ninjas") Ninja ninja) {

		List<Dojo> dojos = dojoService.obtenerTodosLosDojos();
		model.addAttribute("dojos", dojos);

		return "/views/Ninja.jsp"; // Redirige a la página principal o donde desees después de crear el ninja
	}

//	@RequestMapping("/dojos/{id}")
//	public String viewDojoNinjas(@PathVariable("id") Long dojoId, Model model) {
//		Dojo dojo = dojoService.findDojoById(dojoId);
//		if (dojo != null) {
//			List<Ninja> ninjas = dojo.getNinjas();
//			model.addAttribute("dojo", dojo);
//			model.addAttribute("ninjas", ninjas);
//			return "/views/TablaRegistro.jsp"; // Devuelve la vista TablaRegistro.jsp
//		}
//		return "/views/TablaRegistro.jsp"; // Redirige a la página principal o maneja el error si el dojo no existe
//	}

	@RequestMapping("/dojos/{id}")
	public String viewDojoNinjas(@PathVariable("id") Long dojoId, Model model) {
		Dojo dojo = dojoService.findDojoById(dojoId);
		model.addAttribute("dojo", dojo);
		return "/views/TablaRegistro.jsp"; // Devuelve la vista TablaRegistro.jsp
	}
	
	// Mostrar todos los dojos con sus ninjas
	@GetMapping("/")
	public String mostrarDojosNinjas(Model model) {
		List<Object[]> table = dojoService.obtenerDojosConSusNinjas();

		model.addAttribute("table", table);
		return "/views/Query.jsp";
	}

}
