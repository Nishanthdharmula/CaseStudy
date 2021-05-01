package model;

import java.time.LocalDateTime;

public class Flight {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int id;
    private String from;
    private LocalDateTime date;
    private String to;
    private int price;

    public Flight(int id, String from, LocalDateTime date, String to, int price) {
        this.id = id;
        this.from = from;
        this.date = date;
        this.to = to;
        this.price = price;
    }
}
