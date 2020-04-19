package com.example.bmdb.repository;

import com.example.bmdb.domain.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ActorRepo extends CrudRepository<Actor, Long> {
}
