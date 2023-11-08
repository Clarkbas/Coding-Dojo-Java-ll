package com.example.coding.Dojos.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coding.Dojos.models.TagQuestion;

@Repository
public interface TagQuestionRepository extends CrudRepository<TagQuestion,Long> {

}

