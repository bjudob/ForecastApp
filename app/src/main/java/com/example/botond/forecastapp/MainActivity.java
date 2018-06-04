package com.example.botond.forecastapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainMVP.view{

    private Button m_ForecastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainPresenter presenter=new MainPresenter();

        m_ForecastButton=(Button) findViewById(R.id.buttonForecast);

        m_ForecastButton.setOnClickListener(new View.OnClickListener() {
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
