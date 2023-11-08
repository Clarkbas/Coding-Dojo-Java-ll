package com.example.DojoNinja.services;

import com.example.DojoNinja.models.Dojo;
import com.example.DojoNinja.models.Ninja;
import com.example.DojoNinja.repositories.DojoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}

	public void saveDojo(Dojo newDojo) {
		dojoRepository.save(newDojo);
	}

	public Dojo findDojoById(Long dojoId) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(dojoId);
		return optionalDojo.orElse(null);
	}

	public List<Object[]> obtenerDojosConSusNinjas() {
		List<Object[]> table = dojoRepository.joinDojosAndNinjas2();
		for(Object[] row : table) {
		    Dojo dojo = (Dojo) row[0];
		    Ninja ninja = (Ninja) row[1];
		    System.out.println(dojo.getName());
		    System.out.println(ninja.getFirstName());
		}
		return table;
	}

	public List<Dojo> obtenerTodosLosDojos() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
