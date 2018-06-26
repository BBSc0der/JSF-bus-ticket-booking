/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.service;

import com.mycompany.bustickets.entity.Tickets;
import com.mycompany.bustickets.repository.TicketsRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Bolek
 */
@ManagedBean(name = "ticketsService", eager = true)
@Stateless
public class TicketsService {
    
    public TicketsRepository ticketsRepository;
    public TicketsService() {
        ticketsRepository = new TicketsRepository();
    }
    public Tickets saveOrUpdate(Tickets toSave){
        return ticketsRepository.saveOrUpdate(toSave);
    }
    public Tickets findOne(Integer id){
        return ticketsRepository.findOne(id);
    }
    public List<Tickets> findAll() {
        return ticketsRepository.findAll();
    }
}
