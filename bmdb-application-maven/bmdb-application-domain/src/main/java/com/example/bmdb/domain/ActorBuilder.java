package com.example.bmdb.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ActorBuilder {
    private String name;
    private LocalDate born;
    private Sex sex;
    private String biography;
    private List<Media> filmography;

    public ActorBuilder(){
        Initialise();
    }

    public void Initialise() {
        name="deafult";
        born=LocalDate.now();
        sex=Sex.MALE;
        biography="default";
        filmography=new ArrayList<Media>();
    }

    public ActorBuilder buildName(String name) {
        this.name=name;
        return this;
    }

    public ActorBuilder buildBorn(LocalDate born) {
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

    public ActorBuilder buildList(List<Media> filmography) {
        this.filmography=filmography;
        return this;
    }

    public Object getObject() {
        Actor sam = new Actor(name, born, sex, biography);
        sam.setFilmography(filmography);
        return sam;
    }
}
