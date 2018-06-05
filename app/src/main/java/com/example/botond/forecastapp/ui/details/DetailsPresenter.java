package com.example.botond.forecastapp.ui.details;

import android.content.Context;

import com.example.botond.forecastapp.db.ForecastDao;
import com.example.botond.forecastapp.db.ForecastDatabase;
import com.example.botond.forecastapp.db.domain.Forecast;

public class DetailsPresenter implements DetailsMVP.presenter{

    private ForecastDao dao;
    private DetailsMVP.view view;
    private Forecast forecast;

    public DetailsPresenter(DetailsMVP.view view, Context context){
        this.view=view;

        dao= ForecastDatabase.getDatabase(context).dao();
    }

    @Override
    public void loadForecast(int id) {
        forecast=dao.getForecastById(id);

        view.showForecast(forecast);
    }
}
