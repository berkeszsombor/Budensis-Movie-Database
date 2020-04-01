package com.example.bmdb.domain;

import java.math.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Media {
    public BigDecimal id;
    public String title;
    public String description;
    public LocalDate premier;
    private List<Review> reviews;
    private List<Actor> cast;
    public int averageRating = 0;

    public Media(BigDecimal id, String title, String description, LocalDate premier) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.premier = premier;
        this.setReviews(new ArrayList<Review>());
        this.setCast(new ArrayList<Actor>());
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
}
