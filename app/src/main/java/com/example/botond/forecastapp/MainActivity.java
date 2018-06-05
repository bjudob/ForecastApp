package com.example.botond.forecastapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.botond.forecastapp.domain.Forecast;
import com.example.botond.forecastapp.domain.Weather;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity implements MainMVP.view {

    private static final String CURRENTLY = "Currently: ";
    private static final Boolean TESTING = false;
    private static final int GET_LOCATION_REQUEST_CODE = 1234;

    private Button buttonForecast, buttonLocalCoords, buttonFavourite;
    private EditText editTextLatitude, editTextLongitude;
    private TextView textViewCurrently;
    private ListView listViewForecast;
    private ArrayAdapter adapter;

    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainPresenter presenter = new MainPresenter(this);

        buttonLocalCoords = (Button) findViewById(R.id.buttonLocalCoords);
        buttonForecast = (Button) findViewById(R.id.buttonForecast);
        buttonFavourite = (Button) findViewById(R.id.buttonFavourite);
        textViewCurrently = (TextView) findViewById(R.id.textViewCurrently);
        listViewForecast = (ListView) findViewById(R.id.listViewForecast);
        editTextLatitude = (EditText) findViewById(R.id.editTextLatitude);
        editTextLongitude = (EditText) findViewById(R.id.editTextLongitude);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        if (TESTING) {
            editTextLatitude.setText("42.3601");
            editTextLongitude.setText("-71.0589");
        }

        buttonForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.forecastButtonClick(editTextLatitude.getText().toString(), editTextLongitude.getText().toString());
            }
        });

        buttonFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.favouriteButtonClick();
            }
        });

        buttonLocalCoords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                localCoordsButtonClick();
            }
        });


    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showForecast(Forecast forecast) {

        textViewCurrently.setText(CURRENTLY + forecast.getCurrently().getSummary());

        adapter = new ArrayAdapter<Weather>(this,
                R.layout.list_item, forecast.getDaily().getData());

        listViewForecast.setAdapter(adapter);

        buttonFavourite.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideFavouriteButton() {
        buttonFavourite.setVisibility(View.GONE);
    }

    public void localCoordsButtonClick() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            String[] permissions = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
            ActivityCompat.requestPermissions(this, permissions, GET_LOCATION_REQUEST_CODE);
            return;
        }
        getLocalCoordinates();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == GET_LOCATION_REQUEST_CODE) {
            getLocalCoordinates();
        }
    }

    private void getLocalCoordinates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            Double latitude=location.getLatitude();
                            Double longitude=location.getLongitude();

                            editTextLatitude.setText(latitude.toString());
                            editTextLongitude.setText(longitude.toString());
                        }else{
                            showToast("Please turn on the location service!");
                        }
                    }
                });
    }

}
