/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.backing.trips;

import com.mycompany.bustickets.entity.Locations;
import com.mycompany.bustickets.service.LocationsService;
import com.mycompany.bustickets.service.TripsService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Bolek
 */
@Named(value = "addTrip")
@RequestScoped
public class AddTrip {
    
    private List<Locations> locations;
    private String currentDate;
    private Date departure;
    private Locations from;
    private Locations to;
    
    @EJB
    private LocationsService locationsService;
    @EJB
    private TripsService tripsService;
    
    public AddTrip() {
    }
    @PostConstruct
    public void init() {
        locations = locationsService.findAll();
        currentDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        
    }

    public List<Locations> getLocations() {
        return locations;
    }

    public void setLocations(List<Locations> locations) {
        this.locations = locations;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
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

    public LocationsService getLocationsService() {
        return locationsService;
    }

    public void setLocationsService(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    public TripsService getTripsService() {
        return tripsService;
    }

    public void setTripsService(TripsService tripsService) {
        this.tripsService = tripsService;
    }
    
}
