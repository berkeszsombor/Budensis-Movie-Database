package com.example.bmdb.domain;
import java.util.ArrayList;
import java.util.List;

public class User {
	public final String name;
	public final String email;
	private String passWord;
	private List<Review> userReviews;
	
	public User(String Name, String Email, String PassWord) {
		this.name = Name;
		this.email = Email;
		this.setPassword(PassWord);
		setUserReviews(new ArrayList<Review>());
	}
	
	public String getPassword() {
		return passWord;
	}
	
	public void setPassword(String passWord) {
		this.passWord=passWord;
	}
	
	public void addReview(Review rev) {
		this.userReviews.add(rev);
	}
	
	public List<Review> getReview(){
		return this.userReviews;
	}
	
	public void setUserReviews(List<Review> list) {
		this.userReviews=list;
	}
}
