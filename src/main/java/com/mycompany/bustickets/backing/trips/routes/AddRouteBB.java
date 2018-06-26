/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.backing.trips.routes;

import com.mycompany.bustickets.entity.Locations;
import com.mycompany.bustickets.entity.Routes;
import com.mycompany.bustickets.entity.Routeslocations;
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
@Named(value = "addRouteBB")
@ViewScoped
public class AddRouteBB implements Serializable {

    private Routes route;
    private List<Routeslocations> routesLocations;
    private List<Locations> locations;
    private boolean backRoute;
    private String description2;
    
    @EJB
    private RoutesService routesService;
    @EJB
    private LocationsService locationsService;
    
    public AddRouteBB() {
    }
    @PostConstruct
    public void init() {
        routesLocations = new ArrayList<>();
        routesLocations.add(new Routeslocations());
        routesLocations.add(new Routeslocations());
        
        route = new Routes();
        locations = locationsService.findAll();
        backRoute = false;
        description2="";
        
    }
    public void add() {
        System.out.println("it works");
        routesLocations.add(new Routeslocations());
    }

    public void remove(Routeslocations item) {
        routesLocations.remove(item);
    }

    public String save() {
        routesService.saveRoute(route, routesLocations, backRoute, description2);
        
        return "/kursy/trasy/index?faces-redirect=true";
    }

    public Routes getRoute() {
        return route;
    }

    public void setRoute(Routes route) {
        this.route = route;
    }

    public List<Routeslocations> getRoutesLocations() {
        return routesLocations;
    }

    public void setRoutesLocations(List<Routeslocations> routesLocations) {
        this.routesLocations = routesLocations;
    }

    public List<Locations> getLocations() {
        return locations;
    }

    public void setLocations(List<Locations> locations) {
        this.locations = locations;
    }

    public boolean isBackRoute() {
        return backRoute;
    }

    public void setBackRoute(boolean backRoute) {
        this.backRoute = backRoute;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }
    
}
