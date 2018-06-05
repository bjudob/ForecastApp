package com.example.botond.forecastapp.main;

import android.content.Context;

import com.example.botond.forecastapp.domain.Forecast;

public interface MainMVP {
    interface view{
        void showToast(String message);
        void showForecast(Forecast forecast);
        void hideFavouriteButton();
    }

    interface presenter{
        void forecastButtonClick(String latitude, String longitude);
        void favouriteButtonClick();
    }
}
