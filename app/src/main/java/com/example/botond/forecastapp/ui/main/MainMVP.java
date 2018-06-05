package com.example.botond.forecastapp.ui.main;

import android.widget.ProgressBar;

import com.example.botond.forecastapp.db.domain.Forecast;

public interface MainMVP {
    interface view{
        void showToast(String message);
        void showForecast(Forecast forecast);
        void hideFavouriteButton();
        void setProgressBarVisibility(int visibility);
    }

    interface presenter{
        void forecastButtonClick(String latitude, String longitude);
        void favouriteButtonClick();
    }
}
