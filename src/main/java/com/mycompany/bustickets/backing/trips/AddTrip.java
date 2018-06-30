/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.backing.trips;

import com.mycompany.bustickets.entity.Locations;
import com.mycompany.bustickets.entity.Routes;
import com.mycompany.bustickets.entity.Trips;
import com.mycompany.bustickets.service.LocationsService;
import com.mycompany.bustickets.service.RoutesService;
import com.mycompany.bustickets.service.TripsService;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private Trips trip;
    private List<Routes> routes;

    @EJB
    private LocationsService locationsService;
    @EJB
    private TripsService tripsService;
    @EJB
    private RoutesService routesService;

    public AddTrip() {
    }

    @PostConstruct
    public void init() {
        trip = new Trips();
        trip.setBookedSeats(0);
        trip.setPrice(BigDecimal.ZERO);
        trip.setNumberOfSeats(20);
        
        locations = locationsService.findAll();
        routes = routesService.findAll();
        currentDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }
    
    public String addNewTrip(){
        
        return "";
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

    public Trips getTrip() {
        return trip;
    }

    public void setTrip(Trips trip) {
        this.trip = trip;
    }

    public List<Routes> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Routes> routes) {
        this.routes = routes;
    }
    
}
