package com.example.coding.Dojos.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.coding.Dojos.models.Answer;
import com.example.coding.Dojos.models.Question;
import com.example.coding.Dojos.services.DOService;

@Controller
public class HomeController {
	private final DOService dOService;
	
	public HomeController(DOService dOService) {
		
		this.dOService = dOService;
	}

	@GetMapping("/")
	public String notHere() {
		return"redirect:/questions";
	}
	
	@GetMapping("/questions")
	public String dashBoard(Model model) {
		model.addAttribute("questions",dOService.allQuestions());
		return"views/dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("addQuestion")Question question) {
		return"views/newQuestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String addQuestion(@RequestParam("other")String tags, @ModelAttribute("addQuestion")Question question,BindingResult result,RedirectAttributes rA) {
		List<String> tagString = Arrays.asList(tags.split(","));
		if(tagString.size() > 3) {
			System.out.println("tag error at first if");
			String error = "<div class=\"alert alert-danger\" role=\"alert\"> Questions can only have a maximum of 3 tags </div>";
			rA.addFlashAttribute("error", error );
			return "redirect:/questions/new";
		} 
		else if(tags.length() == 0){
			String error = "<div class=\"alert alert-danger\" role=\"alert\"> Your question must have at least one tag </div>";
			rA.addFlashAttribute("error", error );
			System.out.println("tag error at second if");
			return "redirect:/questions/new";
			
		}
		else if(result.hasErrors()) {
			System.out.println("tag error at third if");
			return"views/newQuestion.jsp";
		} 
		else {
			dOService.tagCheckAndSave(tagString, question);
			return "redirect:/";
		}
	}
	
	@GetMapping("/questions/{questionId}")
	public String questionProfile(@ModelAttribute("addTheAnswer")Answer answer,@PathVariable("questionId")Long id,Model model) {
		model.addAttribute("question",dOService.findQuestionById(id));
		return"views/questionProfile.jsp";
	}
	
	@PostMapping("/questions/{questionId}")
	public String addAnswerToQuestion(@ModelAttribute("addTheAnswer")Answer answer,BindingResult result,@PathVariable("questionId")Long id , Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question",dOService.findQuestionById(id));
			return"views/questionProfile.jsp";
		}
		else {
			answer.setQuestion(dOService.findQuestionById(id));
			dOService.saveAnswer(answer);
			return"redirect:/questions/"+id;
		}
	}
	


}
