package com.example.botond.forecastapp.domain;

public class Forecast {

    private String timezone;
    private double latitude;
    private double longitude;

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
}
