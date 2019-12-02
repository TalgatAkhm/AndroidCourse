package com.talgat.layoutcreatingtask2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if(savedInstanceState == null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.listContainer, ListFragment.create(), ListFragment.NAME)
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void showDetailsFragment(@NonNull final long id) {
        if(getSupportFragmentManager().findFragmentByTag(DetailsFragment.NAME) != null){
            getSupportFragmentManager().popBackStack();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.detailsContainer, DetailsFragment.create(id), DetailsFragment.NAME)
                .addToBackStack(null)
                .commit();
    }
}
