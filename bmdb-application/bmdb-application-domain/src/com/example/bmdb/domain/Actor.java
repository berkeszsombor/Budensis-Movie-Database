package com.example.bmdb.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Actor {
    public String name;
    public LocalDate born;
    public Sex sex;
    public String biography;
    private List<Media> filmography;

    public Actor(String Name, LocalDate Born, Sex sex, String Biography) {
        this.name = Name;
        this.born = Born;
        this.sex=sex;
        this.biography = Biography;
        this.setFilmography(new ArrayList<Media>());
    }

    public List<Media> getFilmography() {
        return filmography;
    }

    public void setFilmography(List<Media> filmography) {
        this.filmography = filmography;
    }

    public void addFilmography(Media media) {
        this.filmography.add(media);
    }

    @Override
    public String toString() {
        return String.format("|name: %s born: %s |\n", name, born.toString());
    }
}
