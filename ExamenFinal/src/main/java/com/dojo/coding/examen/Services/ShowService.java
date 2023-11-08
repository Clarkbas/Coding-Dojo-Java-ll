package com.dojo.coding.examen.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.coding.examen.models.Show;
import com.dojo.coding.examen.repositories.ShowRepository;


@Service
public class ShowService {
	private final ShowRepository showRepository;

	public ShowService(ShowRepository showRepository) {
		this.showRepository = showRepository;
	}

	
	public List<Show> allShow(){
		return showRepository.findAll();
	}

	public Show createShow(Show show) {
		return showRepository.save(show);
	}

	public Show findShow(Long id) {
		Optional<Show> optionalShow = showRepository.findById(id);
		if (optionalShow.isPresent()) {
			return optionalShow.get();
		} else {
			return null;
		}
	}

	public Show updateShow(Show show) {
		Optional<Show> optionalShow = showRepository.findById(show.getId());
		if (optionalShow.isPresent()) {
			Show s = optionalShow.get();
			s.setName(show.getName());
			s.setNetwork(show.getNetwork());
			return showRepository.save(s);
		} else {
			return null;
		}
	}

	public void deleteShow(Long id) {
		showRepository.deleteById(id);
	}
	
	public boolean showExists(String showTitle) {
	    return showRepository.existsByName(showTitle);
	}

}
