package com.example.botond.forecastapp.db.domain;

import com.example.botond.forecastapp.utils.DateConverter;

import java.util.Calendar;
import java.util.Date;

public class Weather {
    private double time;
    private String summary;
    private String precipType;
    private double humidity;
    private double precipProbability;
    private double temperature;
    private double uvIndex;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(double uvIndex) {
        this.uvIndex = uvIndex;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        Date date=DateConverter.unixTimeToDate(time);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //Integer year = cal.get(Calendar.YEAR);
        Integer month = cal.get(Calendar.MONTH);
        Integer day = cal.get(Calendar.DAY_OF_MONTH);

        String monthString=DateConverter.intToMonth(month);

        return day.toString()+"."+monthString+": "+summary;

    }
}
