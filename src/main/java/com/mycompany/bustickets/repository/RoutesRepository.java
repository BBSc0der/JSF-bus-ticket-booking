/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.repository;

import com.mycompany.bustickets.entity.Routes;
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
public class RoutesRepository {
    private SessionFactory sf;

    public RoutesRepository() {
        this.sf = HibernateUtil.getSessionFactory();
    }
        public Routes saveOrUpdate(Routes toSave){
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        s.saveOrUpdate(toSave);
        tx.commit();
        s.close();
        return toSave;
    }
    public Routes findOne(Integer id){
        Session s = sf.openSession();
        Query query = s.createQuery("FROM Routes WHERE idRoute= :param");
        query.setParameter("param", id);
        @SuppressWarnings("unchecked")
        
        Routes route = null;
        if(query.list().size() > 0)
            route = (Routes) query.list().get(0);
        
        s.close();
        return route;
    }
    public List<Routes> findAll() {
        Session s = sf.openSession();
        List<Routes> routes = s.createQuery("from Routes").list();
        s.close();
        return routes;
    }
    public boolean deleteOne(Integer id) {

        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        
        Routes persistentInstance = (Routes) s.load(Routes.class, id);
        if (persistentInstance != null) {
            for (Routeslocations sdr : persistentInstance.getRouteslocationses()) {
                s.delete(sdr);
            }
            s.delete(persistentInstance);
        }
        tx.commit();
        s.close();
        return true;

    }
    
}
