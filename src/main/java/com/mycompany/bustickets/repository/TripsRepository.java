/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.repository;

import com.mycompany.bustickets.converters.DateHelper;
import com.mycompany.bustickets.customforms.SearchForm;
import com.mycompany.bustickets.entity.Trips;
import com.mycompany.bustickets.entity.Routeslocations;
import com.mycompany.bustickets.hibernate.HibernateUtil;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Bolek
 */
public class TripsRepository implements Serializable {

    private SessionFactory sf;

    public TripsRepository() {
        this.sf = HibernateUtil.getSessionFactory();
    }

    public Trips saveOrUpdate(Trips toSave) {
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        s.saveOrUpdate(toSave);
        tx.commit();
        s.close();
        return toSave;
    }

    public Trips findOne(Integer id) {
        Session s = sf.openSession();
        Query query = s.createQuery("FROM Trips WHERE idTrip= :param");
        query.setParameter("param", id);
        @SuppressWarnings("unchecked")

        Trips trip = null;
        if (query.list().size() > 0) {
            trip = (Trips) query.list().get(0);
        }

        s.close();
        return trip;
    }

    public List<Trips> findAll() {
        Session s = sf.openSession();
        List<Trips> trips = s.createQuery("from Trips").list();
        s.close();
        return trips;
    }

    public List<Trips> findByDate(Date date) {

        Session s = sf.openSession();
        Query query = s.createQuery("FROM Trips WHERE year(dateOfDeparture)= :year AND month(dateOfDeparture)= :month AND day(dateOfDeparture)= :day");
        query.setParameter("year", DateHelper.getYear(date));
        query.setParameter("month", DateHelper.getMonth(date));
        query.setParameter("day", DateHelper.getDay(date));

        @SuppressWarnings("unchecked")

        List<Trips> trips = null;
        if (query.list().size() > 0) {
            trips = query.list();
        }

        s.close();
        return trips;
    }

    public List<Trips> findByDateAndLocations(SearchForm searchForm) {

        Session s = sf.openSession();
        Query query = s.createQuery("FROM Trips WHERE year(dateOfDeparture)= :year AND month(dateOfDeparture)= :month AND day(dateOfDeparture)= :day "
                + "AND idRoute IN (SELECT r.idRoute FROM Routes r "
                + "JOIN r.routeslocationses rl "
                + "WHERE rl.locations.idLocation = :from AND r.idRoute IN "
                + "(SELECT rl2.routes.idRoute FROM Routeslocations rl2 "
                + "WHERE rl2.locations.idLocation = :to "
                + "AND rl2.stopNumber > rl.stopNumber) "
                + ")");

        query.setParameter("year", DateHelper.getYear(searchForm.getDeparture()));
        query.setParameter("month", DateHelper.getMonth(searchForm.getDeparture()));
        query.setParameter("day", DateHelper.getDay(searchForm.getDeparture()));
        query.setParameter("from", searchForm.getFrom().getIdLocation());
        query.setParameter("to", searchForm.getTo().getIdLocation());

        @SuppressWarnings("unchecked")

        List<Trips> trips = null;
        if (query.list().size() > 0) {
            trips = query.list();
        }

        s.close();
        return trips;
    }
}
