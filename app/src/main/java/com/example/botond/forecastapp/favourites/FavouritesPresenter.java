package com.example.botond.forecastapp.favourites;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.botond.forecastapp.R;
import com.example.botond.forecastapp.db.ForecastDao;
import com.example.botond.forecastapp.db.ForecastDatabase;
import com.example.botond.forecastapp.domain.Forecast;

import java.util.List;

public class FavouritesPresenter implements FavouritesMVP.presenter{

    private ForecastDao dao;
    private FavouritesMVP.view view;

    public FavouritesPresenter(FavouritesMVP.view view, Context context){
        this.view=view;

        dao= ForecastDatabase.getDatabase(context).dao();
    }

    @Override
    public void loadFavourites() {
        List<Forecast> forecasts = dao.getForecasts();

        view.showFavourites(forecasts);
    }

    @Override
    public void listItemClick(int position) {

    }


}
