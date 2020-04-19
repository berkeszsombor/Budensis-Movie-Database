package com.example.bmdb.service;

import com.example.bmdb.domain.User;
import com.example.bmdb.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public List<User> findAllUser() {
        return (List<User>) this.repo.findAll();
    }

    public void saveUser(User user){
            this.repo.save(user);
    }
}
