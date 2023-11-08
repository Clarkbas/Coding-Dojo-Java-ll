package com.example.coding.countries.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coding.countries.models.Language;

@Repository
public interface LanguageRepocitory extends CrudRepository<Language, Long> {

    
}

