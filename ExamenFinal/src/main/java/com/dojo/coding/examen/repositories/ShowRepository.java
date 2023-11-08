package com.dojo.coding.examen.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.coding.examen.models.Show;



@Repository
public interface ShowRepository extends CrudRepository<Show, Long>{

	List<Show> findAll();
	
	boolean existsByName(String name);
}
