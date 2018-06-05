package com.example.botond.forecastapp.domain;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.botond.forecastapp.converter.DateConverter;

import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "forecasts")
public class Forecast {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String timezone;
    private double latitude;
    private double longitude;
    private Weather currently;
    private DailyForecast daily;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Weather getCurrently() {
        return currently;
    }

    public void setCurrently(Weather currently) {
        this.currently = currently;
    }

    public DailyForecast getDaily() {
        return daily;
    }

    public void setDaily(DailyForecast daily) {
        this.daily = daily;
    }

    @Override
    public String toString() {
        Date date= DateConverter.unixTimeToDate(currently.getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //Integer year = cal.get(Calendar.YEAR);
        Integer month = cal.get(Calendar.MONTH);
        Integer day = cal.get(Calendar.DAY_OF_MONTH);

        String monthString=DateConverter.intToMonth(month);

        return day.toString()+"."+monthString+" "+timezone+": "+currently.getSummary();
    }
}
