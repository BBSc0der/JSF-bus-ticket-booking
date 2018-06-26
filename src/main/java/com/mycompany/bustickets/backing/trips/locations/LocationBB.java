/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.backing.trips.locations;

import com.mycompany.bustickets.entity.Locations;
import com.mycompany.bustickets.service.LocationsService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Bolek
 */
@Named(value = "locationBB")
@ViewScoped
public class LocationBB implements Serializable {

    private List<Locations> locations;
    private Locations selected;
    @EJB
    private LocationsService locationsService;
    /**
     * Creates a new instance of LocationBB
     */
    public LocationBB() {
    }
    @PostConstruct
    public void init() {
        locations = locationsService.findAll();
    }
    public String delete(){
        locationsService.deleteOne(selected.getIdLocation());
        return "/kursy/przystanki/index?faces-redirect=true";
    }

    public List<Locations> getLocations() {
        return locations;
    }

    public void setLocations(List<Locations> locations) {
        this.locations = locations;
    }

    public LocationsService getLocationsService() {
        return locationsService;
    }

    public void setLocationsService(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    public Locations getSelected() {
        return selected;
    }

    public void setSelected(Locations selected) {
        this.selected = selected;
    }
    
}
