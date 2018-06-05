package com.example.botond.forecastapp;

import android.content.Context;

import com.example.botond.forecastapp.domain.Forecast;

public interface MainMVP {
    interface view{
        void showToast(String message);
        void showForecast(Forecast forecast);
    }

    interface presenter{
        void forecastButtonClick(String latitude, String longitude);
        void favouriteButtonClick(Forecast forecast);
    }
}
