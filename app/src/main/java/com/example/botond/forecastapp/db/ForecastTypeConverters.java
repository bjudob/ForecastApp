package com.example.botond.forecastapp.db;

import android.arch.persistence.room.TypeConverter;

import com.example.botond.forecastapp.db.domain.DailyForecast;
import com.example.botond.forecastapp.db.domain.Weather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ForecastTypeConverters {
    @TypeConverter
    public static Weather stringToWeather(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Weather>() {}.getType();
        Weather weather = gson.fromJson(json, type);
        return weather;
    }

    @TypeConverter
    public static String weatherToString(Weather weather) {
        Gson gson = new Gson();
        Type type = new TypeToken<Weather>() {}.getType();
        String json = gson.toJson(weather, type);
        return json;
    }

    @TypeConverter
    public static DailyForecast stringToDailyForecast(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<DailyForecast>() {}.getType();
        DailyForecast dailyForecast = gson.fromJson(json, type);
        return dailyForecast;
    }

    @TypeConverter
    public static String dailyForecastToString(DailyForecast dailyForecast) {
        Gson gson = new Gson();
        Type type = new TypeToken<DailyForecast>() {}.getType();
        String json = gson.toJson(dailyForecast, type);
        return json;
    }
}
