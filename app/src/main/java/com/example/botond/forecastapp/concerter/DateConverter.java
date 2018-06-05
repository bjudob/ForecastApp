package com.example.botond.forecastapp.concerter;

import java.util.Date;

public class DateConverter {

    private static String[] months=new String[]{"Jan.", "Febr.","Mar.","Apr.","May","June","July","Aug.","Sept.","Oct.","Nov.","Dec."};

    public static Date unixTimeToDate(double time){
        Date date=new java.util.Date((long)time*1000);

        return date;
    }

    public static String intToMonth(int i){
        if(i<12){
            return months[i];
        }
        else{
            return "Month";
        }
    }
}
