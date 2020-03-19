package com.example.bmdb.domain;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Movie extends Media {

	public Movie(BigDecimal ID, String Title, String Description, LocalDate Premier) {
		super(ID, Title, Description, Premier);
	}

}
