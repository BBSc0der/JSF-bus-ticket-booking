/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.service;

import com.mycompany.bustickets.entity.Locations;
import com.mycompany.bustickets.repository.LocationsRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Bolek
 */
@ManagedBean(name="locationsService", eager = true)
@Stateless
public class LocationsService {
    
    LocationsRepository locationsRepository;
    /**
     * Creates a new instance of LocationsService
     */
    public LocationsService() {
        locationsRepository = new LocationsRepository();
    }
    public Locations saveOrUpdate(Locations toSave){
        return locationsRepository.saveOrUpdate(toSave);
    }
    public List<Locations> findAll(){
        return locationsRepository.findAll();
    }
    public Locations findOne(Integer id){
        return locationsRepository.findOne(id);
    }
    public boolean deleteOne(Integer id) {
        return locationsRepository.deleteOne(id);
    }
}
