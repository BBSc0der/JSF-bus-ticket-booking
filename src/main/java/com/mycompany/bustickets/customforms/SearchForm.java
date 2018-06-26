/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.customforms;

import com.mycompany.bustickets.entity.Locations;
import java.util.Date;

/**
 *
 * @author Bolek
 */
public class SearchForm {
    private Date departure;
    private Locations from;
    private Locations to;

    public SearchForm() {
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
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
