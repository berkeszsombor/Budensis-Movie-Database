package com.example.bmdb.repository;

import com.example.bmdb.domain.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepo extends CrudRepository<Review, String> {
}
