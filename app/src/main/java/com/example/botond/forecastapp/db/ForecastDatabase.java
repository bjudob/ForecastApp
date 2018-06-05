package com.example.botond.forecastapp.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.botond.forecastapp.db.domain.Forecast;

@Database(entities = {Forecast.class},version = 1)
@TypeConverters(ForecastTypeConverters.class)
public abstract class ForecastDatabase extends RoomDatabase{

    private static ForecastDatabase INSTANCE;

    abstract public ForecastDao dao();

    public static ForecastDatabase getDatabase(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(
                    context.getApplicationContext(),
                    ForecastDatabase.class,"forecast-database"
            )
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }

}
