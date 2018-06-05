package com.example.botond.forecastapp.details;

import com.example.botond.forecastapp.domain.Forecast;

import java.util.List;

public interface DetailsMVP {
    interface view{
        void showToast(String message);
        void showForecast(Forecast forecast);
    }

    interface presenter{
        void loadForecast();
    }
}
