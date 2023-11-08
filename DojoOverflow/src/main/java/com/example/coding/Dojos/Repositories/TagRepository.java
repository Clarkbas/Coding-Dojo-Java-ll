package com.example.coding.Dojos.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coding.Dojos.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    Tag findBySubjectIgnoreCase(String subject);
}
