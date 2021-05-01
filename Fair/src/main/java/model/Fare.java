package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="fare")
public class Fare {
	@Id
	private int fareId;
    private double totalbookingPrice;
    private int price;
    
    private int extraLuggage;
    private double gst;
    private double convenienceFee;
	
	

	public int getFareId() {
		return fareId;
	}
	public void setFareId(int fareId) {
		this.fareId = fareId;
	}
	public double getTotalbookingPrice() {
		return totalbookingPrice;
	}
	public void setTotalbookingPrice(double totalbookingPrice) {
		this.totalbookingPrice = totalbookingPrice;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getExtraLuggage() {
		return extraLuggage;
	}
	public void setExtraLuggage(int extraLuggage) {
		this.extraLuggage = extraLuggage;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public double getConvenienceFee() {
		return convenienceFee;
	}
	public void setConvenienceFee(double convenienceFee) {
		this.convenienceFee = convenienceFee;
	}
	public Fare(int fareId, double totalbookingPrice, int price, int extraLuggage, double gst, double convenienceFee) {
		super();
		this.fareId = fareId;
		this.totalbookingPrice = totalbookingPrice;
		this.price = price;
		this.extraLuggage = extraLuggage;
		this.gst = gst;
		this.convenienceFee = convenienceFee;
	}
	
	
	
	
}
