package com.example.bmdb.service;

import com.example.bmdb.domain.Review;
import com.example.bmdb.repository.ReviewRepo;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service
public class ReviewService {
    private ReviewRepo repo;

    @Inject
    public void setRepo(ReviewRepo repo){
        this.repo = repo;
    }

    public void saveReview(Review review){
        repo.save(review);
    }

    public void saveAll(Iterable<Review> reviews){
        repo.saveAll(reviews);
    }

    public Optional<Review> findReviewById(String id){
        return repo.findById(id);
    }
    public Iterable<Review> findAll(){
        return repo.findAll();
    }
}
