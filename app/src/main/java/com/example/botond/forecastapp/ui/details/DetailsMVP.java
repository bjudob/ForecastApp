package com.example.botond.forecastapp.ui.details;

import com.example.botond.forecastapp.db.domain.Forecast;

public interface DetailsMVP {
    interface view{
        void showToast(String message);
        void showForecast(Forecast forecast);
    }

    interface presenter{
        void loadForecast(int id);
    }
}
