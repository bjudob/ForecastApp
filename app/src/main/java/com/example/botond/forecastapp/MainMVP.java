package com.example.botond.forecastapp;

import android.content.Context;

import com.example.botond.forecastapp.domain.Forecast;

public interface MainMVP {
    interface view{
        void showToast(String message);
        void showForecast(Forecast forecast);
        void setLatitudeText(String text);
        void setLongitudeText(String text);
    }

    interface presenter{
        void forecastButtonClick(String latitude, String longitude);
    }
}
