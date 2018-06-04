package com.example.botond.forecastapp.domain;

public class Forecast {

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
}
