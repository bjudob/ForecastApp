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

    public MainPresenter(){
        service= ServiceFactory.createRetrofitService(
                ForecastService.class,
                ForecastService.SERVICE_ENDPOINT);
    }

    @Override
    public void forecastButtonClick() {
        Call<Forecast> call = service.getWeather("42.3601,-71.0589");

        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                Forecast forecast =response.body();
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                view.showToast("Connection failed!");
            }
        });

    }
}
