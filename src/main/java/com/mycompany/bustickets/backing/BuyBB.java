/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.backing;

import com.mycompany.bustickets.customforms.TripElement;
import com.mycompany.bustickets.entity.Tickets;
import com.mycompany.bustickets.entity.Trips;
import com.mycompany.bustickets.service.LocationsService;
import com.mycompany.bustickets.service.TicketsService;
import com.mycompany.bustickets.service.TripsService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Bolek
 */
@Named(value = "buyBB")
@ViewScoped
public class BuyBB implements Serializable {

    private TripElement tripDetails;
    private Tickets ticket;
    private Integer id;
    private Integer from;
    private Integer to;
    List<String> banks;
    String bank;
    boolean checkBox;

    @EJB
    private TripsService tripsService;
    @EJB
    private LocationsService locationsService;
    @EJB
    private TicketsService ticketsService;
    
    public BuyBB() {
    }

    @PostConstruct
    public void init() {
        ticket = new Tickets();
        ticket.setNumOfDiscount(0);
        ticket.setNumOfNormal(0);
        
        banks = new ArrayList<>();
        banks.add("blik");
        banks.add("mTransfers");
        banks.add("przelew24 WZWBK");
        banks.add("Alior bank");
        banks.add("iPKO");
        banks.add("Eurobank");
        banks.add("Millenium");
        banks.add("ING");
        banks.add("Orange");
        banks.add("Getin bank");
    }

    public String buyTicket() {
        System.out.println("dzieje sie ");
        return "platnosc?faces-redirect=true";
    }

    public TripElement loadTripDetails() {

        if (id == null || from == null || to == null) {
            id = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
            from = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("from"));
            to = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("to"));
        }
        if (tripDetails == null || tripDetails.getIdTrip().intValue() != id.intValue()) {
            tripDetails = tripsService.findOneDetails(id, from, to);
            ticket.setTrips(tripsService.findOne(id));
            ticket.setLocationsByFrom(locationsService.findOne(from));
            ticket.setLocationsByTo(locationsService.findOne(to));
        }

        return tripDetails;
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }
    public double totalToBePaid(){
        return ticket.getNumOfNormal() * tripDetails.getPrice() + ticket.getNumOfDiscount() * (0.5 * tripDetails.getPrice());
    }
    
    public String pay(){
        
        if(ticket != null) {
            ticketsService.saveOrUpdate(ticket);
            Trips trip = tripsService.findOne(ticket.getTrips().getIdTrip());
            trip.setBookedSeats(trip.getBookedSeats() + ticket.getNumOfDiscount() + ticket.getNumOfNormal());
            tripsService.saveOrUpdate(trip);
        }
        return "powodzenie?faces-redirect=true";
        
    }

    public TripElement getTripDetails() {
        return tripDetails;
    }

    public void setTripDetails(TripElement tripDetails) {
        this.tripDetails = tripDetails;
    }

    public Tickets getTicket() {
        return ticket;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }

    public List<String> getBanks() {
        return banks;
    }

    public void setBanks(List<String> banks) {
        this.banks = banks;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }
    
}
