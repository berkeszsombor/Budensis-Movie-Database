package com.example.bmdb.service;

import com.example.bmdb.domain.Media;
import com.example.bmdb.repository.MediaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MediaService {
    @Autowired
    private MediaRepo repo;

    public void saveMedia(Media mediaToSave){
        this.repo.save(mediaToSave);
    }

    public Media findMedia(long id) {
        return this.repo.findById(id).orElse(null);
    }

    public List<Media> findAllMedia() {
        return (List<Media>) this.repo.findAll();
    }
}
