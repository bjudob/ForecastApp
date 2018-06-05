package com.example.botond.forecastapp.ui.favourites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.botond.forecastapp.R;
import com.example.botond.forecastapp.db.domain.Forecast;

import java.util.List;

public class FavouritesActivity extends AppCompatActivity implements FavouritesMVP.view{

    private ListView listViewFavourites;
    private FavouritesMVP.presenter presenter;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        presenter=new FavouritesPresenter(this,this);

        listViewFavourites=(ListView) findViewById(R.id.listViewFavs);

        presenter.loadFavourites();

        listViewFavourites. setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                presenter.listItemClick(position);
            }
        });
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFavourites(List<Forecast> forecasts) {
        adapter = new ArrayAdapter<Forecast>(this,
                R.layout.list_item, forecasts);

        listViewFavourites.setAdapter(adapter);
    }
}
