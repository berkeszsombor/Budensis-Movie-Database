package com.example.bmdb.service;

import com.example.bmdb.domain.User;
import com.example.bmdb.repository.UserRepo;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserService {
    private UserRepo repo;

    @Inject
    public void setRepo(UserRepo repo){
        this.repo = repo;
    }

    public void setUsers(List<User> usersToSave){
        for (User userToSave : usersToSave){
            repo.save(userToSave);
        }
    }

    public void saveUser(User userToSave){
        this.repo.save(userToSave);
    }

    public void saveAll(Iterable<User> usersToSave){
        this.repo.saveAll(usersToSave);
    }

    public User findUser(String emailToFind, String passwordToFind) {
        return repo.findByEmailAndPassWord(emailToFind, passwordToFind).get(0);
    }
}
