package com.example.bmdb.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ReviewType")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String text;

    @ManyToOne
    private User creator;

    @ManyToOne
    private Media media;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    //public Review(String Text, User user, Media media, Rating rating) {
    //    this.text = Text;
    //    this.user = user;
    //    this.media=media;
    //    this.rating=rating;
    //}

    public Review(){

    }

    @Override
    public String toString() {
        return String.format("%s\nUser=%s\nMedia=%s\nRating=%d",
                text, creator.name, media.getTitle(), rating.rate);
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Media getMedia() {
        return media;
    }
    public void setMedia(Media media) {
        this.media = media;
    }
    public User getUser() {
        return creator;
    }
    public void setCreator(User user) {
        this.creator = user;
    }
    public Rating getRating() {
        return rating;
    }
    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
