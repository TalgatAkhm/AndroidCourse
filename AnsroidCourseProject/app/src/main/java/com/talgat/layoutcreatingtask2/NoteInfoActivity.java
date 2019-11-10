package com.talgat.layoutcreatingtask2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NoteInfoActivity extends AppCompatActivity {

    private static final String ID_KEY = "ID_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_info);

        long id = getIntent().getLongExtra(ID_KEY, -1);
        Note note = NotesHandler.getNoteById(id);

        TextView noteText = findViewById(R.id.note_full_text);
        noteText.setText(note.getText());

        ImageView noteImage = findViewById(R.id.big_image_view);
        noteImage.setImageResource((int) note.getDrawableIdRes());

        this.setTitle(note.getTitle());
    }

    public static Intent getIntent(Context context, long id)
    {
        Intent intent = new Intent(context, NoteInfoActivity.class);
        intent.putExtra(ID_KEY, id);
        return intent;
    }
}
