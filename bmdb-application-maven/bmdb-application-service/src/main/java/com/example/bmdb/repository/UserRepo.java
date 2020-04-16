package com.example.bmdb.repository;

import com.example.bmdb.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, String> {
    List<User> findByName(String name);
    List<User> findByEmailAndPassWord(String email, String password);
}
