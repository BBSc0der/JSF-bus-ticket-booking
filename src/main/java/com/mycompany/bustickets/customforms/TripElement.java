/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.customforms;

import com.mycompany.bustickets.entity.Locations;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Bolek
 */
public class TripElement implements Serializable {

    private Integer idTrip;
    private Date dateOfDeparture;
    private Date dateOfArrival;
    private int numberOfSeats;
    private int bookedSeats;
    private int price;
    private Locations from;
    private Locations to;

    public TripElement() {
    }

    public Integer getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(Integer idTrip) {
        this.idTrip = idTrip;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Locations getFrom() {
        return from;
    }

    public void setFrom(Locations from) {
        this.from = from;
    }

    public Locations getTo() {
        return to;
    }

    public void setTo(Locations to) {
        this.to = to;
    }
    
}
