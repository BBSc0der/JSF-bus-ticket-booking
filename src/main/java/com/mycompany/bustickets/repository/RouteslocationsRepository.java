/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.repository;

import com.mycompany.bustickets.entity.Routeslocations;
import com.mycompany.bustickets.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Bolek
 */
public class RouteslocationsRepository {

    private SessionFactory sf;

    public RouteslocationsRepository() {
        this.sf = HibernateUtil.getSessionFactory();
    }

    public Routeslocations saveOrUpdate(Routeslocations toSave) {
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        s.saveOrUpdate(toSave);
        tx.commit();
        s.close();
        return toSave;
    }

    public Routeslocations findOne(Integer id) {
        Session s = sf.openSession();
        Query query = s.createQuery("FROM Routeslocations WHERE idRouteLocation= :param");
        query.setParameter("param", id);
        @SuppressWarnings("unchecked")

        Routeslocations routesLoc = null;
        if (query.list().size() > 0) {
            routesLoc = (Routeslocations) query.list().get(0);
        }

        s.close();
        return routesLoc;
    }

    public List<Routeslocations> findAll() {
        Session s = sf.openSession();
        List<Routeslocations> routesLoc = s.createQuery("from Routeslocations").list();
        s.close();
        return routesLoc;
    }

    public boolean deleteOne(Integer id) {

        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        Routeslocations persistentInstance = (Routeslocations) s.load(Routeslocations.class, id);
        if (persistentInstance != null) {
            s.delete(persistentInstance);
        }
        tx.commit();
        s.close();
        return true;

    }
}
