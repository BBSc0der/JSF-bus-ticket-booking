/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bustickets.converters;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Bolek
 */
public class DateHelper {

    public static Date getDateWithoutTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getTomorrowDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    public static Integer getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static Integer getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Integer month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    public static Integer getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static Date addTimes(Date basic, Date add) {
        
        Calendar cBasic = Calendar.getInstance();
        Calendar cAdd = Calendar.getInstance();
        cBasic.setTime(basic);
        cAdd.setTime(add);
        Calendar cTotal = (Calendar) cBasic.clone();
        cTotal.add(Calendar.HOUR_OF_DAY, cAdd.get(Calendar.HOUR_OF_DAY));
        cTotal.add(Calendar.MINUTE, cAdd.get(Calendar.MINUTE));
        cTotal.add(Calendar.SECOND, cAdd.get(Calendar.SECOND));
        cTotal.add(Calendar.MILLISECOND, cAdd.get(Calendar.MILLISECOND));

        return cTotal.getTime();

    }
    public static Date getZeroDate(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.YEAR, 0);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_YEAR, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
