package com.example.coding.test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.coding.test.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {

}
