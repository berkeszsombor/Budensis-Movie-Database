package com.example.bmdb.service;

import com.example.bmdb.domain.Media;
import com.example.bmdb.domain.Review;
import com.example.bmdb.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepo repo;

    public void saveReview(Review review){
        repo.save(review);
    }

    public List<Review> findAllReview() {
        return (List<Review>) this.repo.findAll();
    }

    public List<Review> findAllReview(Media media){
        return media.getReviews();
    }
}
