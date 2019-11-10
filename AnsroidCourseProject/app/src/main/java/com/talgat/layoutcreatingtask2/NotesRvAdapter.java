package com.talgat.layoutcreatingtask2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesRvAdapter extends RecyclerView.Adapter<NotesViewHandler> {

    public interface Listener {
        void onNoteClick(long id);
    }

    private List<Note> notes;
    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesViewHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.note_item,
                parent,
                false
        );
        return new NotesViewHandler(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHandler holder, int position) {
        holder.bind(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
