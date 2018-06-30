/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.converters;

import com.mycompany.bustickets.entity.Locations;
import com.mycompany.bustickets.entity.Routes;
import com.mycompany.bustickets.service.RoutesService;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bolek
 */
@FacesConverter("routeConverter")
public class RouteConverter implements Converter {

    @EJB
    RoutesService routesService;
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                return routesService.findOne(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Nieprawidłowa trasa."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            return String.valueOf(((Routes) value).getIdRoute().intValue());
        }
        else {
            return null;
        }
    }
    
}
