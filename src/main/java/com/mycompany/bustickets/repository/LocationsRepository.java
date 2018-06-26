/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.repository;

import com.mycompany.bustickets.entity.Locations;
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
public class LocationsRepository implements Serializable {
    private SessionFactory sf;

    public LocationsRepository() {
        this.sf = HibernateUtil.getSessionFactory();
    }
    public Locations saveOrUpdate(Locations toSave){
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        s.saveOrUpdate(toSave);
        tx.commit();
        s.close();
        return toSave;
    }
    public Locations findOne(Integer id){
        Session s = sf.openSession();
        Query query = s.createQuery("FROM Locations WHERE idLocation= :param");
        query.setParameter("param", id);
        @SuppressWarnings("unchecked")
        
        Locations location = null;
        if(query.list().size() > 0)
            location = (Locations) query.list().get(0);
        
        s.close();
        return location;
    }
    public List<Locations> findAll() {
        Session s = sf.openSession();
        List<Locations> locations = s.createQuery("from Locations").list();
        s.close();
        return locations;
    }
    public boolean deleteOne(Integer id) {

        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        
        Locations persistentInstance = (Locations) s.load(Locations.class, id);
        if (persistentInstance != null) {
            s.delete(persistentInstance);
        }
        tx.commit();
        s.close();
        return true;

    }
}
