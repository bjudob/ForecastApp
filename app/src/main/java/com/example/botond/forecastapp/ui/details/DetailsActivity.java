package com.example.botond.forecastapp.ui.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.botond.forecastapp.R;
import com.example.botond.forecastapp.db.domain.Forecast;
import com.example.botond.forecastapp.db.domain.Weather;

public class DetailsActivity extends AppCompatActivity implements DetailsMVP.view{

    private static final int DEFAULT_ID = -1;

    private TextView textViewCurrently;
    private ListView listViewFavourites;
    private DetailsMVP.presenter presenter;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        presenter=new DetailsPresenter(this,this);

        listViewFavourites=(ListView) findViewById(R.id.listViewForecastD);
        textViewCurrently=(TextView) findViewById(R.id.textViewCurrentlyD);

        Intent intent = getIntent();
        int id=intent.getIntExtra("id",DEFAULT_ID);

        if(id==-1){
            onBackPressed();
        }
        else{
            presenter.loadForecast(id);
        }



    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void showForecast(Forecast forecast) {
        textViewCurrently.setText(forecast.getCurrently().toString());

        adapter = new ArrayAdapter<Weather>(this,
                R.layout.list_item, forecast.getDaily().getData());

        listViewFavourites.setAdapter(adapter);
    }
}
