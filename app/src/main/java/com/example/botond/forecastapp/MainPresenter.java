package com.example.botond.forecastapp;

import com.example.botond.forecastapp.domain.Weather;
import com.example.botond.forecastapp.service.ServiceFactory;
import com.example.botond.forecastapp.service.WeatherService;

public class MainPresenter implements MainMVP.presenter {

    private WeatherService service;

    public MainPresenter(){
        service= ServiceFactory.createRetrofitService(
                WeatherService.class,
                WeatherService.SERVICE_ENDPOINT);
    }

    @Override
    public void forecastButtonClick() {
        

    }
}
