package com.dojo.coding.examen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.coding.examen.models.Rating;



@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
	
	@Query("SELECT u.name, r.rating FROM Rating r JOIN r.user u WHERE r.show.id = :showId")
	List<Object[]> nombreRatingPorId(Long showId);
	
	@Query("SELECT AVG(r.rating) FROM Rating r WHERE r.show.id = :showId")
	List<Double> promedioRating( Long showId);
	

	

}
