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
import javax.faces.context.FacesContext;

/**
 *
 * @author Bolek
 */
@Named(value = "editLocationBB")
@RequestScoped
public class EditLocationBB {

    private Locations location;
    
    @EJB
    private LocationsService locationsService;
    
    public EditLocationBB() {
    }
    @PostConstruct
    public void init() {
        Integer id = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
        if(id != null)
            location = locationsService.findOne(id);
        else
            location = new Locations();
    }
    public String saveLocation(){
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
