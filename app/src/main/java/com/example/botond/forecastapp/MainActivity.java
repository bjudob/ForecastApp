package com.example.botond.forecastapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainMVP.view{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void showToast(String message) {
        Toast.makeText(this.getBaseContext(),message,
                Toast.LENGTH_SHORT).show();
    }
}
