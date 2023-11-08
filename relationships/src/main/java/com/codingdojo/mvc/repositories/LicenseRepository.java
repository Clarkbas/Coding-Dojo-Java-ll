package com.codingdojo.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
    //Este método recupera todas las preguntas de la base de datos
    List<License> findAll();

	Optional<License> findByPersonId(Long personId);
}
