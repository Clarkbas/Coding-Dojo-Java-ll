package com.example.coding.countries.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coding.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
	
	//1
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = ?1 ORDER BY l.percentage desc")
	List<Object[]> countrySpeaksLanguageByPercentage(String language);
	
	//4
	@Query("SELECT c, l FROM Country c JOIN c.languages l WHERE l.percentage > 89 ORDER BY l.percentage DESC")
	static
	List<Object[]> countrySpeaksLanguageByPercentage_4() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//
	@Query("SELECT co,ci FROM Country co JOIN co.cities ci WHERE co.name = 'Argentina' AND ci.district = 'Buenos Aires' AND ci.population > 500000")
	List<Object[]> countrySpeaksLanguageByPercentage_6(String language);
	
}
