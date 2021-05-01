package com.Review.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Review")
public class Review {
	
	@Transient
    public static final String SEQUENCE_NAME = "review_sequence";
	
	@Id
	private int id;
	public Review(int id, int rating, String message) {
		super();
		this.id = id;
		this.rating = rating;
		this.message = message;
	}
	private int rating;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
