/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.service;

import com.ibm.icu.text.ArabicShaping;
import com.mycompany.bustickets.converters.DateHelper;
import com.mycompany.bustickets.customforms.SearchForm;
import com.mycompany.bustickets.customforms.TripElement;
import com.mycompany.bustickets.entity.Routeslocations;
import com.mycompany.bustickets.entity.Trips;
import com.mycompany.bustickets.repository.LocationsRepository;
import com.mycompany.bustickets.repository.TripsRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Bolek
 */
@ManagedBean(name = "tripsService", eager = true)
@Stateless
public class TripsService {

    TripsRepository tripsRepository;
    LocationsRepository locationsRepository;

    /**
     * Creates a new instance of LocationsService
     */
    public TripsService() {
        tripsRepository = new TripsRepository();
        locationsRepository = new LocationsRepository();
    }
    public Trips saveOrUpdate(Trips toSave) {
        return tripsRepository.saveOrUpdate(toSave);
    }

    public List<Trips> findAll() {
        return tripsRepository.findAll();
    }

    public Trips findOne(Integer id) {
        return tripsRepository.findOne(id);
    }

    public List<Trips> findByDate(Date date) {
        return tripsRepository.findByDate(date);
    }

    public List<Trips> findByDateAndLocations(SearchForm searchForm) {
        return tripsRepository.findByDateAndLocations(searchForm);
    }

    public List<TripElement> findByDateAndLocations2(SearchForm searchForm) {
        List<Trips> trips = tripsRepository.findByDateAndLocations(searchForm);
        List<TripElement> tripsElements = new ArrayList<>();
        if (trips != null) {
            for (Trips trip : trips) {

                tripsElements.add(transformTrip(trip, searchForm));
            }
        }
        return tripsElements;
    }

    public TripElement findOneDetails(Integer id, Integer from, Integer to) {
        SearchForm searchForm = new SearchForm();
        searchForm.setFrom(locationsRepository.findOne(from));
        searchForm.setTo(locationsRepository.findOne(to));
        TripElement tripDetails = transformTrip(tripsRepository.findOne(id), searchForm);
        return tripDetails;
    }

    private TripElement transformTrip(Trips trip, SearchForm searchForm) {
        TripElement newTrip = new TripElement();
        newTrip.setIdTrip(trip.getIdTrip());
        newTrip.setBookedSeats(trip.getBookedSeats());
        newTrip.setNumberOfSeats(trip.getNumberOfSeats());
        newTrip.setFrom(searchForm.getFrom());
        newTrip.setTo(searchForm.getTo());

        int fromOrderNum = 0;
        int toOrderNum = 0;
        for (Routeslocations rLoc : trip.getRoutes().getRouteslocationses()) {
            if (rLoc.getLocations().getCity().equals(searchForm.getFrom().getCity())) {
                fromOrderNum = rLoc.getStopNumber();
            }
            if (rLoc.getLocations().getCity().equals(searchForm.getTo().getCity())) {
                toOrderNum = rLoc.getStopNumber();
            }
        }
        int finalPrice;
        Date dateOfDeparture = (Date) trip.getDateOfDeparture().clone();
        int kilometers = 0;
        int lengthOfRoute = 0;
        for (Routeslocations rLoc : trip.getRoutes().getRouteslocationses()) {
            lengthOfRoute += rLoc.getDistanceBetweenStops();
            if (rLoc.getStopNumber() <= fromOrderNum) {
                dateOfDeparture = DateHelper.addTimes(dateOfDeparture, rLoc.getTimeBetweenStops());
            }
        }
        Date dateOfArrival = (Date) dateOfDeparture.clone();
        for (Routeslocations rLoc : trip.getRoutes().getRouteslocationses()) {
            if (rLoc.getStopNumber() > fromOrderNum && rLoc.getStopNumber() <= toOrderNum) {
                kilometers += rLoc.getDistanceBetweenStops();
                dateOfArrival = DateHelper.addTimes(dateOfArrival, rLoc.getTimeBetweenStops());
            }
        }

        finalPrice = (int) ( trip.getPrice().doubleValue() * ((double) kilometers / (double) lengthOfRoute));

        newTrip.setDateOfDeparture(dateOfDeparture);
        newTrip.setDateOfArrival(dateOfArrival);
        newTrip.setPrice(finalPrice);
        
        return newTrip;
    }
}
