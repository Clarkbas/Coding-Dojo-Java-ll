package com.example.Lookify.Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.Lookify.Models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long> {

    List<Lookify> findAll();
    List<Lookify> findTop10ByOrderByRatingDesc();
    List<Lookify> findByArtistContainsAllIgnoreCase(String search);
}
