package com.example.botond.forecastapp.favourites;


import com.example.botond.forecastapp.domain.Forecast;

import java.util.List;

public interface FavouritesMVP {
    interface view{
        void showToast(String message);
        void showFavourites(List<Forecast> forecasts);
    }

    interface presenter{
        void loadFavourites();
        void listItemClick(int position);
    }
}
