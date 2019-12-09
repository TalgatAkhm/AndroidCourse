package com.talgat.layoutcreatingtask2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public final class DetailsFragment extends Fragment {
    public static final String NAME = DetailsFragment.class.getName();

    private static final String ID_KEY = "ID";

    public static Fragment create(@NonNull final long id) {
        final Fragment fragment = new DetailsFragment();

        final Bundle args = new Bundle();
        args.putLong(ID_KEY, id);

        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        long id = getArguments().getLong(ID_KEY);
        Note note = NotesStorage.getNoteById(id);

        TextView noteText = view.findViewById(R.id.note_full_text);
        noteText.setText(note.getText());

        ImageView noteImage = view.findViewById(R.id.big_image_view);
        noteImage.setImageResource(note.getDrawableIdRes());
    }
}
