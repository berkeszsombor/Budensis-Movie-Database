package com.example.bmdb.repository;

import com.example.bmdb.domain.Series;
import org.springframework.data.repository.CrudRepository;

public interface SeriesRepo extends CrudRepository<Series, String> {
}
