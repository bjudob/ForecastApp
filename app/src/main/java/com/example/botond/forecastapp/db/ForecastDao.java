package com.example.botond.forecastapp.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.botond.forecastapp.db.domain.Forecast;

import java.util.List;

@Dao
public interface ForecastDao {

    @Query("select * from forecasts")
    List<Forecast> getForecasts();

    @Insert
    void insertForecast(Forecast fc);

    @Insert
    void insertForecasts(List<Forecast> list);

    @Query("DELETE FROM forecasts WHERE 1")
    void deleteAll();

}
