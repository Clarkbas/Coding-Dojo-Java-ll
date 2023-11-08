package com.example.coding.Dojos.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coding.Dojos.models.Answer;


@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long> {

}

