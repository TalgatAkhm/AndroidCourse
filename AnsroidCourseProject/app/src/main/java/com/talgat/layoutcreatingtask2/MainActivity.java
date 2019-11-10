package com.talgat.layoutcreatingtask2;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements NotesRvAdapter.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        this.setTitle(R.string.main_activity_title);

        NotesHandler.create(this);
        final RecyclerView recyclerView = findViewById(R.id.notesRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 15);

        final NotesRvAdapter adapter = new NotesRvAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNotes(NotesHandler.getNotes());
        adapter.setListener(this);
    }

    @Override
    public void onNoteClick(long id) {
        startActivity(NoteInfoActivity.getIntent(this, id));
    }
}
