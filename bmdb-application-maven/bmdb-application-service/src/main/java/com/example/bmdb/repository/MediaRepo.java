package com.example.bmdb.repository;

import com.example.bmdb.domain.Media;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MediaRepo extends CrudRepository<Media, String> {
    @Override
    Iterable<Media> findAll();

    @Override
    Optional<Media> findById(String s);
}
