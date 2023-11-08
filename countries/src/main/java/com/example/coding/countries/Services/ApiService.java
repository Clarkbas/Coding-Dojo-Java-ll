package com.example.coding.countries.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.coding.countries.Repositories.CityRepocitory;
import com.example.coding.countries.Repositories.CountryRepository;
import com.example.coding.countries.Repositories.LanguageRepocitory;

@Service
public class ApiService {
	private final LanguageRepocitory languageRepocitory;
	private CountryRepository countryRepository;
	private CityRepocitory cityRepocitory;
	
	public ApiService(CountryRepository cR, LanguageRepocitory lR, CityRepocitory ctyR) {
		this.countryRepository = cR;
		this.languageRepocitory = lR;
		this.cityRepocitory = ctyR;
	}
	
	public List<Object[]> question1(String language){
		return countryRepository.countrySpeaksLanguageByPercentage(language);
	}
	
	
}
