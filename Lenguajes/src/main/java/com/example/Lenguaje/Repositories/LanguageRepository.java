package com.example.Lenguaje.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Lenguaje.Models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	
    //Este método recupera todos los libros de la base de datos
    List<Language> findAll();


}