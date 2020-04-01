package com.example.bmdb.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MediaBuilder {
    private BigDecimal id;
    private String title;
    private String description;
    private LocalDate premier;
    private List<Review> reviews;
    private List<Actor> cast;
    private Boolean IsMovie;

    public MediaBuilder(){
        Initialise();
    }

    public void Initialise() {
        title="deafult";
        description="deafult";
        premier=LocalDate.now();
        reviews=new ArrayList<Review>();
        cast=new ArrayList<Actor>();
    }

    public MediaBuilder buildId(BigDecimal id) {
        this.id=id;
        return this;
    }

    public MediaBuilder buildTitle(String title) {
        this.title=title;
        return this;
    }

    public MediaBuilder buildDescription(String description) {
        this.description=description;
        return this;
    }

    public MediaBuilder buildPremier(LocalDate premier) {
        this.premier=premier;
        return this;
    }

    public MediaBuilder buildReviewList(List<Review> reviews) {
        this.reviews=reviews;
        return this;
    }

    public MediaBuilder buildCastList(List<Actor> cast) {
        this.cast=cast;
        return this;
    }

    public MediaBuilder buildMovie() {
        this.IsMovie=true;
        return this;
    }

    public MediaBuilder buildSeries() {
        this.IsMovie=false;
        return this;
    }

    public Object getObject(List<Actor> cast) {
        if(IsMovie) {
            Movie sam = new Movie(id, title, description, premier);
            sam.setCast(cast);
            sam.setReviews(new ArrayList<Review>());
            return sam;
        }
        else {
            Series sam = new Series(id, description, description, premier);
            sam.setCast(new ArrayList<Actor>());
            sam.setReviews(new ArrayList<Review>());
            return sam;
        }
    }
}
