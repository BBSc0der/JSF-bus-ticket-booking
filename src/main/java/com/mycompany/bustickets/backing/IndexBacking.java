/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.backing;

import com.mycompany.bustickets.customforms.SearchForm;
import com.mycompany.bustickets.customforms.TripElement;
import com.mycompany.bustickets.entity.Locations;
import com.mycompany.bustickets.service.LocationsService;
import com.mycompany.bustickets.service.TripsService;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Bolek
 */
@Named(value = "indexBacking")
@RequestScoped
public class IndexBacking implements Serializable {
    
    private List<Locations> locations;
    private String currentDate;
    private SearchForm searchForm;
    private List<TripElement> searchedTrips;
    
    @EJB
    private LocationsService locationsService;
    @EJB
    private TripsService tripsService;
    
    public IndexBacking() {
    }
    @PostConstruct
    public void init() {
        locations = locationsService.findAll();
        currentDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        searchForm = new SearchForm();
        
    }
    // obsluga formularza
    public String search(){
        searchedTrips = tripsService.findByDateAndLocations2(searchForm);
        
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

    public SearchForm getSearchForm() {
        return searchForm;
    }

    public void setSearchForm(SearchForm searchForm) {
        this.searchForm = searchForm;
    }

    public List<TripElement> getSearchedTrips() {
        return searchedTrips;
    }

    public void setSearchedTrips(List<TripElement> searchedTrips) {
        this.searchedTrips = searchedTrips;
    }
    
    
}
