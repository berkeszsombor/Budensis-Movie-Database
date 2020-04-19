package com.example.bmdb.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("mediaType")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date premier;

    @OneToMany(mappedBy = "media" ,fetch = FetchType.EAGER/*, cascade = {CascadeType.ALL}*/)
    @Fetch(FetchMode.SUBSELECT)
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.EAGER/*, cascade = {CascadeType.ALL}*/)
    @JoinTable
    @Fetch(FetchMode.SUBSELECT)
    private List<Actor> cast;

    public Media(){

    }
    public Media(String title, String description, Date premier) {
        this.title = title;
        this.description = description;
        this.premier = premier;
        this.reviews = new ArrayList<Review>();
        this.cast = new ArrayList<Actor>();
    }

    @Override
    public String toString() {
        return String.format("\n%s = %s\nDescription=%s\nPremier=%s\nCast=%s\nReviews=\n%s",
                id,
                title,
                description,
                premier.toString(),
                getCast(),
                getReviews());
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public List<Review> getReviews() {
        return reviews;
    }
    public void addReviews(Review review) {
        this.reviews.add(review);
    }
    public List<Actor> getCast(){
        return this.cast;
    }
    public void addCast(Actor actor) {
        this.cast.add(actor);
    }
}
