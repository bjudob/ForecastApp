package com.example.botond.forecastapp.ui.favourites;


import com.example.botond.forecastapp.db.domain.Forecast;

import java.util.List;

public interface FavouritesMVP {
    interface view{
        void showToast(String message);
        void showFavourites(List<Forecast> forecasts);
        void showDetails(int id);
    }

    interface presenter{
        void loadFavourites();
        void listItemClick(int position);
    }
}
