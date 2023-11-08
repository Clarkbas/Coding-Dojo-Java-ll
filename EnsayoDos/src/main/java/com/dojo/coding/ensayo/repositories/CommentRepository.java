package com.dojo.coding.ensayo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.coding.ensayo.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {

}
