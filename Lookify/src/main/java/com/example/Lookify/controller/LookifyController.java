package com.example.Lookify.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Lookify.Models.Lookify;
import com.example.Lookify.Services.LookifyService;

import jakarta.validation.Valid;

@Controller
public class LookifyController {

	private final LookifyService lookifyServices;

	public LookifyController(LookifyService lookifyService) {
		this.lookifyServices = lookifyService;
	}
	
	@RequestMapping("/")
	public String start() {
		return "views/start.jsp";
	}
	
	@RequestMapping("/dashboard")//metodo dashboard
	public String dashboard(@ModelAttribute("songName") Lookify song, Model model){
		List<Lookify> songs = lookifyServices.allSongs();
		model.addAttribute("songs",songs);
		return "views/dashboard.jsp";
	}
	
	@PostMapping("songs/new")
	public String add(@Valid @ModelAttribute("music") Lookify song, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return"views/add.jsp";
		}
		else {
			lookifyServices.addSong(song);
			return"redirect:/dashboard";
		}
	}
	
	@GetMapping("songs/new")
	public String add(@ModelAttribute("music") Lookify song) {
		return"views/add.jsp";
	}
	
	@DeleteMapping("/dashboard/{songId}")//metodo destroy
	public String destroy(@PathVariable("songId") Long id) {
		lookifyServices.deleteSong(id);
		return"redirect:/dashboard";
	}
	
	@RequestMapping("/songs/{songId}")// metodo info
	public String info(@PathVariable("songId") Long id, Model model) {
		Lookify song = lookifyServices.findSong(id);
		model.addAttribute("song",song);
		return "views/info.jsp";
	}
	
	@RequestMapping("search/topten") //metodo Topten
		public String topTen(Model model) {
			List<Lookify> top = lookifyServices.topTen();
			model.addAttribute("top",top);
			return "views/top.jsp";
			
	}
	
	@PostMapping ("/search")//metodo seach por el nombre
	public String search(@ModelAttribute("songName") Lookify song) {
		return"redirect:/search/"+song.getName();
	}
	
	@RequestMapping("/search/{search}") //metodo Results, donde encuentra todos los resultados de la busqueda
	public String result(@ModelAttribute("songName") Lookify song,@PathVariable("search")String search, Model model) {
		List<Lookify> results = lookifyServices.searchBy(search);
		model.addAttribute("search",search);
		model.addAttribute("results",results);
		return "views/search.jsp";
	}
}