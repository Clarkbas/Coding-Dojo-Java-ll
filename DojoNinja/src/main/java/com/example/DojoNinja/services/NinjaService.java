package com.example.DojoNinja.services;

import org.springframework.stereotype.Service;

import com.example.DojoNinja.models.Ninja;
import com.example.DojoNinja.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}

	public Ninja saveNinja(Ninja newNinja) {
		return ninjaRepository.save(newNinja);
	}

}
