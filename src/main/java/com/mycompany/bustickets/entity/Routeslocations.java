package com.mycompany.bustickets.entity;
// Generated 2017-06-20 15:53:46 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Routeslocations generated by hbm2java
 */
@Entity
@Table(name="routeslocations"
    ,catalog="busticket"
)
public class Routeslocations  implements java.io.Serializable {


     private Integer idRouteLocation;
     private Locations locations;
     private Routes routes;
     private int stopNumber;
     private Date timeBetweenStops;
     private int distanceBetweenStops;

    public Routeslocations() {
    }

    public Routeslocations(Locations locations, Routes routes, int stopNumber, Date timeBetweenStops, int distanceBetweenStops) {
       this.locations = locations;
       this.routes = routes;
       this.stopNumber = stopNumber;
       this.timeBetweenStops = timeBetweenStops;
       this.distanceBetweenStops = distanceBetweenStops;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idRouteLocation", unique=true, nullable=false)
    public Integer getIdRouteLocation() {
        return this.idRouteLocation;
    }
    
    public void setIdRouteLocation(Integer idRouteLocation) {
        this.idRouteLocation = idRouteLocation;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idLocation", nullable=false)
    public Locations getLocations() {
        return this.locations;
    }
    
    public void setLocations(Locations locations) {
        this.locations = locations;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="dRoute", nullable=false)
    public Routes getRoutes() {
        return this.routes;
    }
    
    public void setRoutes(Routes routes) {
        this.routes = routes;
    }

    
    @Column(name="stopNumber", nullable=false)
    public int getStopNumber() {
        return this.stopNumber;
    }
    
    public void setStopNumber(int stopNumber) {
        this.stopNumber = stopNumber;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="timeBetweenStops", nullable=false, length=8)
    public Date getTimeBetweenStops() {
        return this.timeBetweenStops;
    }
    
    public void setTimeBetweenStops(Date timeBetweenStops) {
        this.timeBetweenStops = timeBetweenStops;
    }

    
    @Column(name="distanceBetweenStops", nullable=false)
    public int getDistanceBetweenStops() {
        return this.distanceBetweenStops;
    }
    
    public void setDistanceBetweenStops(int distanceBetweenStops) {
        this.distanceBetweenStops = distanceBetweenStops;
    }




}


