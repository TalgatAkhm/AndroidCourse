package com.talgat.layoutcreatingtask2;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements NotesRvAdapter.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        this.setTitle(R.string.main_activity_title);

        final RecyclerView recyclerView = findViewById(R.id.notesRecyclerView);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        else
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 3);

        final NotesRvAdapter adapter = new NotesRvAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNotes(NotesStorage.getNotes());
        adapter.setListener(this);
    }

    @Override
    public void onNoteClick(long id) {
        startActivity(NoteInfoActivity.getIntent(this, id));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        final RecyclerView recyclerView = findViewById(R.id.notesRecyclerView);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        else
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
