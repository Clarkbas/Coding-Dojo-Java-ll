package com.JairoBurgos.Events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.Events.models.Comment;

@Repository
public interface CommentRepo extends CrudRepository<Comment,Long> {

}
