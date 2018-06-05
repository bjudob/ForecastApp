package com.example.botond.forecastapp.concerter;

import java.util.Date;

public class DateConverter {

    public static Date unixTimeToDate(double time){
        Date date=new java.util.Date((long)time*1000);

        return date;
    }
}
