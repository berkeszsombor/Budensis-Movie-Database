package com.example.bmdb.repository;

import com.example.bmdb.domain.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ActorRepo extends CrudRepository<Actor, String> {
    @Query(
            value = "SELECT actor from Actor INNER JOIN FETCH actor.filmography WHERE actor.id = :id",
            countQuery = "SELECT COUNT(actor) FROM Actor actor INNER JOIN actor.filmography WHERE actor.id = :id"
    )
    Optional<Actor> findActorById(
            @Param("id") String id
    );
}
