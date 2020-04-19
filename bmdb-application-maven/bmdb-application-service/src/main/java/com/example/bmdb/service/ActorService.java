package com.example.bmdb.service;

import com.example.bmdb.domain.Actor;
import com.example.bmdb.repository.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ActorService {
    @Autowired
    private ActorRepo repo;

    public List<Actor> findAllActor() {
        return (List<Actor>) this.repo.findAll();
    }

    public void saveActor(Actor actor) {
        this.repo.save(actor);
    }
}
