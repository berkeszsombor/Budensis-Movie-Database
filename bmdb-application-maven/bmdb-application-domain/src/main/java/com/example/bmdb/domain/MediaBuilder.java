package com.example.bmdb.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class MediaBuilder {
    private String title;
    private String description;
    private Date premier;
    private List<Review> reviews;
    private List<Actor> cast;
    private Boolean IsMovie;

    public MediaBuilder(){
        this.reviews = new ArrayList<>();
        this.cast = new ArrayList<>();
    }


    public MediaBuilder buildTitle(String title) {
        this.title=title;
        return this;
    }

    public MediaBuilder buildDescription(String description) {
        this.description=description;
        return this;
    }

    public MediaBuilder buildPremier(Date premier) {
        this.premier=premier;
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

    public MediaBuilder addActor(Actor act) {
        this.cast.add(act);
        return this;
    }

    public MediaBuilder addReview(Review review) {
        this.reviews.add(review);
        return this;
    }

    public Media build() {
        if(IsMovie) {
            Movie sam = new Movie(this.title, this.description, this.premier);
            for (Review rev : this.reviews){
                sam.addReviews(rev);
            }
            for (Actor act : this.cast){
                sam.addCast(act);
            }
            return sam;
        }
        else {
            Series sam = new Series(this.title, this.description, this.premier);
            for (Review rev : this.reviews){
                sam.addReviews(rev);
            }
            for (Actor act : this.cast){
                sam.addCast(act);
            }
            return sam;
        }
    }
}
