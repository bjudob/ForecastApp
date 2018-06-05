package com.example.botond.forecastapp;


import com.example.botond.forecastapp.domain.Forecast;
import com.example.botond.forecastapp.service.ServiceFactory;
import com.example.botond.forecastapp.service.ForecastService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainMVP.presenter {

    private ForecastService service;
    private MainMVP.view view;
    private Forecast forecastCurrent;

    public MainPresenter(MainMVP.view view) {
        this.view = view;

        service = ServiceFactory.createRetrofitService(
                ForecastService.class,
                ForecastService.SERVICE_ENDPOINT);
    }

    @Override
    public void forecastButtonClick(String latitude, String longitude) {

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

            Call<Forecast> call = service.getWeather(coords);

            call.enqueue(new Callback<Forecast>() {
                @Override
                public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                    Forecast forecast = response.body();

                    forecastCurrent=forecast;
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

    @Override
    public void favouriteButtonClick() {


        view.showToast("Forecast saved to favourites!");
        view.hideFavouriteButton();
    }

}
