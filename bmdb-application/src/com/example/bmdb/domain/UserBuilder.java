package com.example.bmdb.domain;
import java.util.ArrayList;
import java.util.List;

public class UserBuilder {
	private String name;
	private String email;
	private String passWord;
	private List<Review> userReviews;
	
	public UserBuilder(){
		Initialise();
	}
	
	public void Initialise() {
		name="deafult";
		email="default";
		passWord="default";
		userReviews=new ArrayList<Review>();
	}
	
	public UserBuilder buildName(String name) {
		this.name=name;
		return this;
	}
	
	public UserBuilder buildEmail(String email) {
		this.email=email;
		return this;
	}
	
	public UserBuilder buildPassWord(String passWord) {
		this.passWord=passWord;
		return this;
	}
	
	public UserBuilder buildList(List<Review> userReviews) {
		this.userReviews=userReviews;
		return this;
	}
	
	public Object getObject() {
		User sam = new User(name, email, passWord);
		sam.setUserReviews(userReviews);
		return sam;
	}
}
