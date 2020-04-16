package com.example.bmdb.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public  String name;

    public  String email;

    private String passWord;

    @OneToMany(mappedBy = "creator", fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @Fetch(FetchMode.SUBSELECT)
    private List<Review> userReviews;

    //public User(String Name, String Email, String PassWord) {
    //    this.name = Name;
    //   this.email = Email;
    //   this.setPassword(PassWord);
    //   setUserReviews(new ArrayList<Review>());
    //}

    public User(){

    }

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}
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
