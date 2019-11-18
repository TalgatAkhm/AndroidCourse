package com.talgat.layoutcreatingtask2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;

public final class NotesViewHandler extends RecyclerView.ViewHolder {
    private final TextView noteTitleView;
    private final TextView noteTextView;
    private final TextView noteDateView;
    private final ImageView noteImageView;
    private long id;

    public NotesViewHandler(@NonNull View itemView, final NotesRvAdapter.Listener listener) {
        super(itemView);

        noteTitleView = itemView.findViewById(R.id.card_title);
        noteTextView = itemView.findViewById(R.id.card_text);
        noteDateView = itemView.findViewById(R.id.card_date);
        noteImageView = itemView.findViewById(R.id.card_image);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onNoteClick(id);
            }
        });
    }

    public void bind(Note note) {
        noteTitleView.setText(note.getTitle());
        noteTextView.setText(note.getText());
        noteDateView.setText(new SimpleDateFormat("dd.MM.yyyy").format(note.getDate()));
        noteImageView.setImageResource((int) note.getDrawableIdRes());
        id = note.getId();
    }
}
