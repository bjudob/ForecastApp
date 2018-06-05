package com.example.botond.forecastapp.favourites;


public interface FavouritesMVP {
    interface view{
        void showToast(String message);
    }

    interface presenter{
        void listItemClick();
        void loadList();
    }
}
