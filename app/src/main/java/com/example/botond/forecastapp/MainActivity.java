package com.example.botond.forecastapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainMVP.view{

    private Button buttonForecast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainPresenter presenter=new MainPresenter();

        buttonForecast =(Button) findViewById(R.id.buttonForecast);

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
}
