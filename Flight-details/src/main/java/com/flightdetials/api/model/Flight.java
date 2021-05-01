package com.flightdetials.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Flight")
public class Flight {
	
	@Transient
    public static final String SEQUENCE_NAME = "review_sequence";
	@Id
	private int id;
	
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	private String flightName;
	private String from;
	private String to;
	private String date;
	private String time;
	private String price;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Flight(int id, String flightName, String from, String to, String date, String time, String price) {
		super();
		this.id = id;
		this.flightName = flightName;
		this.from = from;
		this.to = to;
		this.date = date;
		this.time = time;
		this.price = price;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

