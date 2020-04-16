package com.example.bmdb.repository;

import com.example.bmdb.domain.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie, String> {
}
