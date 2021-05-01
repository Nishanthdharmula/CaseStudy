package com.booking.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bookings")
public class Bookings {
	
	@Transient
    public static final String SEQUENCE_NAME = "booking_sequence";
	@Transient
    public static final String SEQUENCE_PNR = "bookingpnr_sequence";
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private int pnr;
	private String contactNumber;
	private String gender;

	
	
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
	public Bookings(int id, String firstName, String lastName, int pnr, String contactNumber, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pnr = pnr;
		this.contactNumber = contactNumber;
		this.gender = gender;
	}
	
	
	
	
	

}
