package com.example.Lenguaje.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Lenguaje.Models.Language;
import com.example.Lenguaje.Repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private static LanguageRepository languageRepository = null;

    public LanguageService(LanguageRepository languageRepository) {
        LanguageService.languageRepository = languageRepository;
    }

    public static List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    public static Language getLanguageById(Long id) {
        return languageRepository.findById(id).orElse(null);
    }

    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }

    public static void updateLanguage(Language updatedLanguage) {
        Language existingLanguage = languageRepository.findById(updatedLanguage.getId()).orElse(null);
        if (existingLanguage != null) {
            existingLanguage.setName(updatedLanguage.getName());
            languageRepository.save(existingLanguage);
        }
    }

    public static void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }
}
