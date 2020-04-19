package com.example.bmdb.domain;

import org.springframework.stereotype.Component;

@Component
public class ReviewBuilder {
    private String text;
    private User user;
    private Media media;
    private Rating rating;

    public ReviewBuilder(){
    }

    public ReviewBuilder buildText(String text) {
        this.text=text;
        return this;
    }

    public ReviewBuilder buildUser(User user) {
        this.user=user;
        return this;
    }

    public ReviewBuilder buildMedia(Media media) {
        this.media=media;
        return this;
    }

    public ReviewBuilder buildRating(Rating rating) {
        this.rating=rating;
        return this;
    }

    public Review build() {
        Review sam = new Review(text, user, media, rating);
        return sam;
    }
}
