package com.example.botond.forecastapp.ui.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.botond.forecastapp.R;
import com.example.botond.forecastapp.db.domain.Forecast;

public class DetailsActivity extends AppCompatActivity implements DetailsMVP.view{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void showForecast(Forecast forecast) {

    }
}
