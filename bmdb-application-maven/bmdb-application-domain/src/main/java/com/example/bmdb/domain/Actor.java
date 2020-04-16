package com.example.bmdb.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date born;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(length = 999)
    private String biography;

    @ManyToMany(mappedBy = "cast",fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @Fetch(FetchMode.SUBSELECT)
    private List<Media> filmography;

    //public Actor(String Name, LocalDate Born, Sex sex, String Biography) {
    //    this.name = Name;
    //    this.born = Born;
    //    this.sex=sex;
    //    this.biography = Biography;
    //    this.setFilmography(new ArrayList<Media>());
    //}

    public Actor(){

    }

    @Override
    public String toString() {
        return String.format("|name: %s born: %s |\n", name, born.toString());
    }

    public long getId(){
        return this.id;
    }
    public void setId(long id){this.id = id;}
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Date getBorn() {
        return this.born;
    }
    public void setBorn(Date born) {
        this.born = born;
    }
    public String getBiography() {
        return biography;
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }
    public Sex getSex() {
        return sex;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
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



}
