package com.talgat.layoutcreatingtask2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NoteInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_info);
        this.setTitle("Note 1");
    }
}
