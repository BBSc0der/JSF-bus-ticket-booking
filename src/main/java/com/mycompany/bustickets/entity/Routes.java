package com.mycompany.bustickets.entity;
// Generated 2017-06-20 15:53:46 by Hibernate Tools 4.3.1


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Routes generated by hbm2java
 */
@Entity
@Table(name="routes"
    ,catalog="busticket"
)
public class Routes  implements java.io.Serializable {


     private Integer idRoute;
     private String description;
     private List<Routeslocations> routeslocationses = new ArrayList<Routeslocations>(0);
     private Set<Trips> tripses = new HashSet<Trips>(0);

    public Routes() {
    }

    public Routes(String description, List<Routeslocations> routeslocationses, Set<Trips> tripses) {
       this.description = description;
       this.routeslocationses = routeslocationses;
       this.tripses = tripses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idRoute", unique=true, nullable=false)
    public Integer getIdRoute() {
        return this.idRoute;
    }
    
    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    
    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="routes")
    public List<Routeslocations> getRouteslocationses() {
        return this.routeslocationses;
    }
    
    public void setRouteslocationses(List<Routeslocations> routeslocationses) {
        this.routeslocationses = routeslocationses;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="routes")
    public Set<Trips> getTripses() {
        return this.tripses;
    }
    
    public void setTripses(Set<Trips> tripses) {
        this.tripses = tripses;
    }
    
        @Override
    public String toString() {
        return this.description;
    }
    @Override
    public boolean equals(Object other) {
        return (idRoute != null && other != null && getClass() == other.getClass())
         ? idRoute.equals(((Routes) other).idRoute)
         : (other == this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.description);
        return hash;
    }




}


