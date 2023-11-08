package com.example.ApiService.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Person;

@Repository
public interface StudentRepository extends CrudRepository<Person, Long>{
    //Este método recupera todas las preguntas de la base de datos
    List<Person> findAll();
    
    Optional<Person> findById(Long personId);

	List<Person> findByLicenseIsNull();
}
