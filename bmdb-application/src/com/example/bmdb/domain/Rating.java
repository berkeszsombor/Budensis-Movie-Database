package com.example.bmdb.domain;
import java.util.HashMap;
import java.util.Map;

public enum Rating {
	BAD(1), AVERAGE(3), GOOD(5);
	
	public final int rate;
	private Rating(int rate) {
		this.rate = rate;
	}
	
	private static final Map<Rating, Integer> BY_RATE=new HashMap<>();
	static {
		for (Rating r:values()) {
			BY_RATE.put(r,r.rate);
		}
	}
	
	public static int valueOfRating(Rating rating) {
		return BY_RATE.get(rating);
	}
	
	public static Rating intToRating(int intToConvert) {
		Rating ratingToReturn;
		if(intToConvert==1) {
			ratingToReturn=Rating.BAD;
		}
		else if(intToConvert==3) {
			ratingToReturn=Rating.AVERAGE;
		}
		else {
			ratingToReturn=Rating.GOOD;
		}
		return ratingToReturn;
	}
}
