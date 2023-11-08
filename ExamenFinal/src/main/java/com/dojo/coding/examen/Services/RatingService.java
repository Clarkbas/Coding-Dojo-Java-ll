package com.dojo.coding.examen.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.coding.examen.models.Rating;
import com.dojo.coding.examen.repositories.RatingRepository;


@Service
public class RatingService {

	
	@Autowired
	private RatingRepository ratingRepository;
	
	public List<Object[]> obtenerCalificacionesPorIdDeShow(Long showId) {
	    List<Object[]> calificaciones = ratingRepository.nombreRatingPorId(showId);
	    return calificaciones;
	}
	
	public List<Double> promedioPorRating(Long showId){
		List<Double> promedio = ratingRepository.promedioRating(showId);
		return promedio;
	}
	
	public Rating createRating(Rating rating) {
		return ratingRepository.save(rating);
	}


}
