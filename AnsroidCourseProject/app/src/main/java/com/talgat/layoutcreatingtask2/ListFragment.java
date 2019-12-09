package com.talgat.layoutcreatingtask2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class ListFragment extends Fragment implements NotesRvAdapter.Listener {
    public static final String NAME = ListFragment.class.getName();

    private FrameLayout currentFrameLayout;

    public static Fragment create() {
        return new ListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        currentFrameLayout = new FrameLayout(Objects.requireNonNull(getActivity()));

        final RecyclerView recyclerView = view.findViewById(R.id.notesRecyclerView);

        if (shouldSetTwoSpan())
            recyclerView.setLayoutManager(new GridLayoutManager(currentFrameLayout.getContext(), 2));
        else
            recyclerView.setLayoutManager(new LinearLayoutManager(currentFrameLayout.getContext()));

        recyclerView.setHasFixedSize(true);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 4);

        final NotesRvAdapter adapter = new NotesRvAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNotes(NotesStorage.getNotes());
        adapter.setListener(this);
    }

    @Override
    public void onNoteClick(long id) {
        ((MainActivity) getActivity()).showDetailsFragment(id);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        final RecyclerView recyclerView = currentFrameLayout.findViewById(R.id.notesRecyclerView);

        if (shouldSetTwoSpan()) {
            recyclerView.setLayoutManager(new GridLayoutManager(currentFrameLayout.getContext(), 2));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(currentFrameLayout.getContext()));
        }
    }

    private boolean shouldSetTwoSpan() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE && getResources().getBoolean(R.bool.is_phone)
                || getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT && !getResources().getBoolean(R.bool.is_phone);
    }
}
