/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.repository;

import com.mycompany.bustickets.entity.Tickets;
import com.mycompany.bustickets.hibernate.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Bolek
 */
public class TicketsRepository implements Serializable {
    private SessionFactory sf;

    public TicketsRepository() {
        this.sf = HibernateUtil.getSessionFactory();
    }
     public Tickets saveOrUpdate(Tickets toSave){
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        s.saveOrUpdate(toSave);
        tx.commit();
        s.close();
        return toSave;
    }
    public Tickets findOne(Integer id){
        Session s = sf.openSession();
        Query query = s.createQuery("FROM Tickets WHERE idTicket= :param");
        query.setParameter("param", id);
        @SuppressWarnings("unchecked")
        
        Tickets ticket = null;
        if(query.list().size() > 0)
            ticket = (Tickets) query.list().get(0);
        
        s.close();
        return ticket;
    }
    public List<Tickets> findAll() {
        Session s = sf.openSession();
        List<Tickets> tickets = s.createQuery("from Tickets").list();
        s.close();
        return tickets;
    }
    
}
