package com.example.botond.forecastapp;

import android.util.Log;
import android.view.View;

import com.example.botond.forecastapp.domain.Weather;
import com.example.botond.forecastapp.service.ServiceFactory;
import com.example.botond.forecastapp.service.WeatherService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class MainPresenter implements MainMVP.presenter {

    private WeatherService service;
    private MainMVP.view view;

    public MainPresenter(){
        service= ServiceFactory.createRetrofitService(
                WeatherService.class,
                WeatherService.SERVICE_ENDPOINT);
    }

    @Override
    public void forecastButtonClick() {
        Call<Weather> call = service.getWeather();

        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Weather weather=response.body();
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                view.showToast("Connection failed!");
            }
        });

    }
}
