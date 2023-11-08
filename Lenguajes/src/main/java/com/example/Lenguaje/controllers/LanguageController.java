package com.example.Lenguaje.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Lenguaje.Models.Language;
import com.example.Lenguaje.Services.LanguageService;

import jakarta.validation.Valid;

@Controller
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/languages")
    public String showLanguageForm(Model model) {
        List<Language> languages = languageService.getAllLanguages();
        model.addAttribute("languages", languages);

        // Agregar un objeto "language" vacío al modelo para el formulario de creación
        model.addAttribute("language", new Language());

        return "language.jsp";
    }

    @PostMapping("/languages")
    public String createLanguage(@Valid @ModelAttribute("languages") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "language.jsp";
        }

        languageService.createLanguage(language);
        return "redirect:/languages";
    }


    @GetMapping("/languages/{id}")
    public String showLanguageDetails(@PathVariable Long id, Model model) {
        Language language = languageService.getLanguageById(id);
        if (language == null) {
            return "redirect:/languages/all";
        }
        model.addAttribute("language", language);
        return "details.jsp";
    }

    @GetMapping("/languages/{id}/edit")
    public String showEditLanguageForm(@PathVariable Long id, Model model) {
        Language language = languageService.getLanguageById(id);
        if (language == null) {
            return "redirect:/languages/all";
        }
        model.addAttribute("language", language);
        return "edit.jsp";
    }

    @PutMapping("/languages/{id}")
    public String updateLanguage(@PathVariable Long id, @Valid @ModelAttribute("language") Language updatedLanguage, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        }

        languageService.updateLanguage(updatedLanguage);
        return "redirect:/languages/all";
    }

    @DeleteMapping("/languages/{id}")
    public String deleteLanguage(@PathVariable Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages/all";
    }

}


