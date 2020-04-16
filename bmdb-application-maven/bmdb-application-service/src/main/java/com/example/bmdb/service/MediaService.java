package com.example.bmdb.service;

import com.example.bmdb.domain.Media;
import com.example.bmdb.repository.MediaRepo;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MediaService {
    private MediaRepo repo;

    @Inject
    public void setRepo(MediaRepo repo){
        this.repo = repo;
    }

    public void saveMedia(Media mediaToSave){
        this.repo.save((mediaToSave));
    }

    public void saveAll(Iterable<Media> mediaToSave){
        if (mediaToSave != null){
            repo.saveAll(mediaToSave);
        }
    }

    public Media findMediaById(String id){
        return repo.findById(id).get();
    }

    public Iterable<Media> findAllMedia(){
        return repo.findAll();
    }

    public double getAverageRating(String id){
        double result = repo.findById(id).get()
                .getReviews().stream()
                .mapToInt(lambda -> lambda.getRating().rate)
                .sum();
        double count = repo.findById(id).get()
                .getReviews().stream().count();
        double resultToReturn = result/count;
        return resultToReturn;
    }
}
