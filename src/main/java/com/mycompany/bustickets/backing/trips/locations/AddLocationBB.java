/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.backing.trips.locations;

import com.mycompany.bustickets.entity.Locations;
import com.mycompany.bustickets.service.LocationsService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Bolek
 */
@Named(value = "addLocationBB")
@RequestScoped
public class AddLocationBB {

    private Locations location;
    
    @EJB
    private LocationsService locationsService;
    /**
     * Creates a new instance of addLocationBB
     */
    public AddLocationBB() {
    }
    @PostConstruct
    public void init() {
        location = new Locations();
    }
    public String addLocation(){
        locationsService.saveOrUpdate(location);
        return "/kursy/przystanki/index?faces-redirect=true";
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }
    
}
