package com.example.bmdb.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@DiscriminatorValue("MovieType")
public class Movie extends Media {
    public Movie(){
    }
    public Movie(String title, String description, Date premier) {
        super(title, description, premier);
    }

}
