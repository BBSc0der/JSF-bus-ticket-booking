/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.backing.trips.routes;

import com.mycompany.bustickets.entity.Locations;
import com.mycompany.bustickets.entity.Routes;
import com.mycompany.bustickets.service.LocationsService;
import com.mycompany.bustickets.service.RoutesService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Bolek
 */
@Named(value = "routesBB")
@ViewScoped
public class RoutesBB implements Serializable {

    private List<Routes> routes;
    private List<String> locations;
    private Routes selected;
    
    @EJB
    private RoutesService routesService;
    @EJB
    private LocationsService locationsService;
    /**
     * Creates a new instance of RoutesBB
     */
    public RoutesBB() {
    }
    
    @PostConstruct
    public void init() {
        routes = routesService.findAll();
        locations = new ArrayList<>();
        for(Locations location : locationsService.findAll()){
            locations.add(location.getCity());
        }
    }
    
    public String delete(){
        routesService.deleteOne(selected.getIdRoute());
        return "/kursy/trasy/index?faces-redirect=true";
    }

    public List<Routes> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Routes> routes) {
        this.routes = routes;
    }

    public Routes getSelected() {
        return selected;
    }

    public void setSelected(Routes selected) {
        this.selected = selected;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }
    
    
    
}
