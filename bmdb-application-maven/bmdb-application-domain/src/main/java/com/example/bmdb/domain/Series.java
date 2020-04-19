package com.example.bmdb.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn
public class Series extends Media {
    public Series(){
    }
    public Series(String title, String description, Date premier) {
        super(title, description, premier);
    }
}
