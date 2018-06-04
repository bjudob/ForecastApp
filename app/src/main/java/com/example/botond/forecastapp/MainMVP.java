package com.example.botond.forecastapp;

import com.example.botond.forecastapp.domain.Forecast;

public interface MainMVP {
    interface view{
        void showToast(String message);
        public void showForecast(Forecast forecast);
    }

    interface presenter{
        void forecastButtonClick();
    }
}
