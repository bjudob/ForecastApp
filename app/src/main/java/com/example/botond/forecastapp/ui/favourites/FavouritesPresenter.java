package com.example.botond.forecastapp.ui.favourites;

import android.content.Context;
import android.icu.util.ValueIterator;

import com.example.botond.forecastapp.db.ForecastDao;
import com.example.botond.forecastapp.db.ForecastDatabase;
import com.example.botond.forecastapp.db.domain.Forecast;

import java.util.List;

public class FavouritesPresenter implements FavouritesMVP.presenter{

    private ForecastDao dao;
    private FavouritesMVP.view view;
    List<Forecast> forecasts;

    public FavouritesPresenter(FavouritesMVP.view view, Context context){
        this.view=view;

        dao= ForecastDatabase.getDatabase(context).dao();
    }

    @Override
    public void loadFavourites() {
        forecasts = dao.getForecasts();

        view.showFavourites(forecasts);
    }

    @Override
    public void listItemClick(int position) {
        Forecast selected = forecasts.get(position);

        view.showDetails(selected.getId());
    }


}
