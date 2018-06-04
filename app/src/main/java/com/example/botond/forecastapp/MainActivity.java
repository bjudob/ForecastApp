package com.example.botond.forecastapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.botond.forecastapp.domain.Forecast;
import com.example.botond.forecastapp.domain.Weather;

public class MainActivity extends AppCompatActivity implements MainMVP.view{

    private static final String CURRENTLY  = "Currently: ";

    private Button buttonForecast;
    private TextView textViewCurrently;
    private ListView listViewForecast;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainPresenter presenter=new MainPresenter(this);

        buttonForecast =(Button) findViewById(R.id.buttonForecast);
        textViewCurrently=(TextView) findViewById(R.id.textViewCurrently);
        listViewForecast=(ListView) findViewById(R.id.listViewForecast);

        buttonForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.forecastButtonClick();
            }
        });


    }


    @Override
    public void showToast(String message) {
        Toast.makeText(this.getBaseContext(),message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showForecast(Forecast forecast) {
        textViewCurrently.setText(CURRENTLY + forecast.getCurrently().getSummary());

        adapter = new ArrayAdapter<Weather>(this,
                R.layout.list_item, forecast.getDaily().getData());

        listViewForecast.setAdapter(adapter);
    }


}
