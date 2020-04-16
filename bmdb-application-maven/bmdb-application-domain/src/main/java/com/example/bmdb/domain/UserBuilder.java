package com.example.bmdb.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserBuilder {
    private String name;
    private String email;
    private String passWord;
    private List<Review> userReviews;

    public UserBuilder(){
        Initialise();
    }

    public void Initialise() {
        name="deafult";
        email="default";
        passWord="default";
        userReviews=new ArrayList<Review>();
    }

    public UserBuilder buildName(String name) {
        this.name=name;
        return this;
    }

    public UserBuilder buildEmail(String email) {
        this.email=email;
        return this;
    }

    public UserBuilder buildPassWord(String passWord) {
        this.passWord=passWord;
        return this;
    }

    public UserBuilder buildList(List<Review> userReviews) {
        this.userReviews=userReviews;
        return this;
    }

    public User build() {
        User sam = new User();
        sam.setName(name);
        sam.setEmail(email);
        sam.setPassword(passWord);
        sam.setUserReviews(userReviews);
        return sam;
    }
}