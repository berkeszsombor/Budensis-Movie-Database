package com.example.bmdb.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("MovieType")
public class Movie extends Media {
    public Movie(){

    }
}
