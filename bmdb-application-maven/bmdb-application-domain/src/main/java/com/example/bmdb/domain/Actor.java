package com.example.bmdb.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToMany(mappedBy = "cast",fetch = FetchType.EAGER/*, cascade = {CascadeType.ALL}*/)
    @Fetch(FetchMode.SUBSELECT)
    private List<Media> filmography;

    public Actor(String Name, Date Born, Sex sex, String Biography) {
        this.name = Name;
        this.born = Born;
        this.sex=sex;
        this.biography = Biography;
        this.filmography = new ArrayList<>();
    }

    public Actor(){

    }

    @Override
    public String toString() {
        return String.format("|name: %s born: %s |\n", name, born);
    }
}
