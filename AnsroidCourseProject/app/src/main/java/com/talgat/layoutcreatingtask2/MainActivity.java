package com.talgat.layoutcreatingtask2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.listContainer, ListFragment.create(), ListFragment.NAME)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public void showDetailsFragment(@NonNull final long id) {
        if (getSupportFragmentManager().findFragmentByTag(DetailsFragment.NAME) != null) {
            getSupportFragmentManager().popBackStack();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.detailsContainer, DetailsFragment.create(id), DetailsFragment.NAME)
                .addToBackStack(null)
                .commit();
    }
}
