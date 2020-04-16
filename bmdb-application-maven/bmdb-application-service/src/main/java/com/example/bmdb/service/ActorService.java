package com.example.bmdb.service;

import com.example.bmdb.domain.Actor;
import com.example.bmdb.repository.ActorRepo;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ActorService {
    private ActorRepo repo;

    @Inject
    public void setRepo(ActorRepo repo){
        this.repo = repo;
    }

    public void saveOne(Actor actorToSave){
        this.repo.save((actorToSave));
    }

    public void saveAll(Iterable<Actor> actorsToSave){
        if (actorsToSave != null){
            repo.saveAll(actorsToSave);
        }
    }

    public Actor findActorById(String id){
        return repo.findActorById(id).get();
    }

    public Iterable<Actor> findAllActors(){
        return repo.findAll();
    }
}
