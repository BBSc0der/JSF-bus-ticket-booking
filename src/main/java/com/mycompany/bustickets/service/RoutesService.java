/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.service;

import com.mycompany.bustickets.converters.DateHelper;
import com.mycompany.bustickets.entity.Routes;
import com.mycompany.bustickets.entity.Routeslocations;
import com.mycompany.bustickets.repository.RoutesRepository;
import com.mycompany.bustickets.repository.RouteslocationsRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Bolek
 */
@ManagedBean(name = "routesService", eager = true)
@Stateless
public class RoutesService {

    RoutesRepository routesRepository;
    RouteslocationsRepository routeslocationsRepository;

    /**
     * Creates a new instance of RoutesRepository
     */
    public RoutesService() {
        routesRepository = new RoutesRepository();
        routeslocationsRepository = new RouteslocationsRepository();
    }

    public Routes saveOrUpdate(Routes toSave) {
        return routesRepository.saveOrUpdate(toSave);
    }

    public List<Routes> findAll() {
        return routesRepository.findAll();
    }

    public Routes findOne(Integer id) {
        return routesRepository.findOne(id);
    }

    public boolean deleteOne(Integer id) {
        return routesRepository.deleteOne(id);
    }

    public void saveRoute(Routes toSave, List<Routeslocations> rLocations, boolean backRoute, String description2) {

        routesRepository.saveOrUpdate(toSave);

        for (int i = 0; i < rLocations.size(); i++) {
            rLocations.get(i).setRoutes(toSave);
            rLocations.get(i).setStopNumber(i + 1);
            if (rLocations.get(i).getStopNumber() == 1) {
                rLocations.get(i).setDistanceBetweenStops(0);
                rLocations.get(i).setTimeBetweenStops(DateHelper.getZeroDate());
            }
            routeslocationsRepository.saveOrUpdate(rLocations.get(i));
        }
        if (backRoute == true) {
            Routes newBackRoute = new Routes();
            newBackRoute.setDescription(description2);
            routesRepository.saveOrUpdate(newBackRoute);
            
            int newIndex = 1;
            for (int i = rLocations.size() - 1; i >= 0; i--) {
                Routeslocations newLocation = new Routeslocations(); 
                newLocation.setLocations(rLocations.get(i).getLocations()); 
                newLocation.setStopNumber(newIndex);
                newLocation.setRoutes(newBackRoute);
                if( newIndex == 1){
                    newLocation.setDistanceBetweenStops(0);
                    newLocation.setTimeBetweenStops(DateHelper.getZeroDate());
                }else{
                    newLocation.setDistanceBetweenStops(rLocations.get(i+1).getDistanceBetweenStops());
                    newLocation.setTimeBetweenStops(rLocations.get(i+1).getTimeBetweenStops());
                }
                routeslocationsRepository.saveOrUpdate(newLocation);
                newIndex++;
            }
        }

    }

}
