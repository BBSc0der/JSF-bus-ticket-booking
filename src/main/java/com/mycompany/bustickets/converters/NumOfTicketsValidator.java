/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Bolek
 */
@FacesValidator("numOfTicketsValidator")
public class NumOfTicketsValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
         
        int numOfNormal = (int) value;

        UIInput confirmComponent = (UIInput) component.getAttributes().get("discountTickets");
        int numOfDiscount = Integer.valueOf(((String) confirmComponent.getSubmittedValue()));
        

        if (numOfNormal + numOfDiscount < 1) {
            confirmComponent.setValid(false); // So that it's marked invalid.
            throw new ValidatorException(new FacesMessage("Niepoprawna liczba biletów"));
        }
    }
    
}
