package com.example.bmdb.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("mediaType")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private String title;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date premier;

    @OneToMany(mappedBy = "media" ,fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @Fetch(FetchMode.SUBSELECT)
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    @Fetch(FetchMode.SUBSELECT)
    private List<Actor> cast;
    public int averageRating = 0;

    public Media(){

    }
    //public Media(BigDecimal id, String title, String description, LocalDate premier) {
    //    this.id = id;
    //    this.title = title;
    //    this.description = description;
    //    this.premier = premier;
    //    this.setReviews(new ArrayList<Review>());
    //    this.setCast(new ArrayList<Actor>());
    //}

    @Override
    public String toString() {
        return String.format("\n%s = %s\nDescription=%s\nPremier=%s\nAverage Rating=%d\nCast=%s\nReviews=\n%s",
                id,
                title,
                description,
                premier.toString(),
                averageRating,
                getCast(),
                getReviews());
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getPremier() {
        return premier;
    }
    public void setPremier(Date premier) {
        this.premier = premier;
    }
    public List<Review> getReviews() {
        return reviews;
    }
    public void addReviews(Review review) {
        this.reviews.add(review);
    }
    public void setReviews(List<Review> reviews) {
        this.reviews=reviews;
    }
    public List<Actor> getCast(){
        return this.cast;
    }
    public void addCast(Actor actor) {
        this.cast.add(actor);
    }
    public void setCast(List<Actor> cast) {
        this.cast=cast;
    }
}
