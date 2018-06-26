/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.service;

import com.mycompany.bustickets.entity.Routeslocations;
import com.mycompany.bustickets.repository.RouteslocationsRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Bolek
 */
@ManagedBean(name = "routeslocationsService", eager = true)
@Stateless
public class RouteslocationsService {

    RouteslocationsRepository routeslocationsRepository;

    public Routeslocations saveOrUpdate(Routeslocations toSave) {
        return routeslocationsRepository.saveOrUpdate(toSave);
    }

    public Routeslocations findOne(Integer id) {
        return routeslocationsRepository.findOne(id);
    }

    public List<Routeslocations> findAll() {
        return routeslocationsRepository.findAll();
    }

    public boolean deleteOne(Integer id) {
        return routeslocationsRepository.deleteOne(id);
    }
}
