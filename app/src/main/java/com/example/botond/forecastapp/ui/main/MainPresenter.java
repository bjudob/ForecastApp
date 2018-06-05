package com.example.botond.forecastapp.ui.main;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.ProgressBar;

import com.example.botond.forecastapp.db.ForecastDao;
import com.example.botond.forecastapp.db.ForecastDatabase;
import com.example.botond.forecastapp.db.domain.Forecast;
import com.example.botond.forecastapp.service.ServiceFactory;
import com.example.botond.forecastapp.service.ForecastService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainMVP.presenter {

    private ForecastService service;
    private MainMVP.view view;
    private Forecast forecastCurrent;
    private ForecastDao dao;
    private Context context;

    public MainPresenter(MainMVP.view view, Context context) {
        this.view = view;
        this.context=context;

        service = ServiceFactory.createRetrofitService(
                ForecastService.class,
                ForecastService.SERVICE_ENDPOINT);

        dao= ForecastDatabase.getDatabase(context).dao();

        if(!networkConnectivity(context)){
            view.showToast("No internet connection!");
        }
    }

    @Override
    public void forecastButtonClick(String latitude, String longitude) {
        if(!networkConnectivity(context)){
            view.showToast("No internet connection!");
        }
        else {
            try {
                double testLat = Double.parseDouble(latitude);
                double testLong = Double.parseDouble(longitude);

                if (testLat < -180 || testLat > 180) {
                    throw new NumberFormatException("Latitude out of range");
                }
                if (testLong < -180 || testLong > 180) {
                    throw new NumberFormatException("Longitude out of range");
                }

                String coords = latitude + "," + longitude;

                view.setProgressBarVisibility(View.VISIBLE);
                Call<Forecast> call = service.getWeather(coords);

                call.enqueue(new Callback<Forecast>() {
                    @Override
                    public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                        Forecast forecast = response.body();

                        forecastCurrent = forecast;
                        view.showForecast(forecastCurrent);
                    }

                    @Override
                    public void onFailure(Call<Forecast> call, Throwable t) {
                        view.showToast("Something went wrong!");
                    }
                });
            } catch (NumberFormatException e) {
                view.showToast("Invalid coordinates!");
            }
        }
    }

    @Override
    public void favouriteButtonClick() {
        insertForecast(forecastCurrent);

        view.showToast("Forecast saved to favourites!");
        view.hideFavouriteButton();
    }

    void insertForecast(final Forecast forecast) {
        new Thread(new Runnable() {
            public void run() {
                dao.insertForecast(forecast);
            }
        }).start();
    }

    boolean networkConnectivity(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

}
