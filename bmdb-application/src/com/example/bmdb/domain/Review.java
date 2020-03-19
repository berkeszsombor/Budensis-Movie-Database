package com.example.bmdb.domain;

public class Review {
	public String text;
	public User user;
	public Media media;
	public Rating rating;
	
	public Review(String Text, User user, Media media, Rating rating) {
		this.text = Text;
		this.user = user;
		this.media=media;
		this.rating=rating;
	}
	
	@Override
	public String toString() {
		return String.format("%s\nUser=%s\nMedia=%s\nRating=%d",
				text, user.name, media.title, rating.rate);
	}
}
