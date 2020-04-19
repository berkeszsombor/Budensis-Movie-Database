package com.example.bmdb.domain;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class ActorBuilder {
    private String name;
    private Date born;
    private Sex sex;
    private String biography;
    private List<Media> filmography;

    public ActorBuilder(){
        this.filmography = new ArrayList<>();
    }

    public ActorBuilder buildName(String name) {
        this.name=name;
        return this;
    }

    public ActorBuilder buildBorn(Date born) {
        this.born=born;
        return this;
    }

    public ActorBuilder buildSex(Sex sex) {
        this.sex=sex;
        return this;
    }

    public ActorBuilder buildBiography(String biography) {
        this.biography=biography;
        return this;
    }

    public Actor build() {
        Actor sam = new Actor(this.name, this.born, this.sex, this.biography);
        return sam;
    }
}
