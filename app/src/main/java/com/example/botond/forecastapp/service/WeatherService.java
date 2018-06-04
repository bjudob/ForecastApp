package com.example.botond.forecastapp.service;

import com.example.botond.forecastapp.domain.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherService {
    String KEY = "d86c7b39b933a92d3c3710792d00dae0";
    String SERVICE_ENDPOINT = "https://api.darksky.net/forecast/";

    @GET("/{coordinates}")
    Call<Weather> getWeather(@Path("coordinates") String name);


}

