package com.talgat.layoutcreatingtask2;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class NotesHandler {
    private static final Map<Long, Note> NOTE_MAP = new HashMap<>();

    private static final int NOTES_NUMBER = 100;

    public static void create(Context context) {
        for (int i = 0; i < NOTES_NUMBER; i++) {
            String title = "cat" + i;
            String text = i + "___" + context.getString(R.string.big_string);
            Date date = new Date(); // set to current time millis
            long drawableResId = getImageResById(i % 3);

            Note note = new Note(i, date, text, title, drawableResId);

            NOTE_MAP.put((long) i, note);
        }
    }

    private NotesHandler() {
        // Empty
    }

    public static List<Note> getNotes() {
        return new ArrayList<>(NOTE_MAP.values());
    }

    public static Note getNoteById(long id) {
        return NOTE_MAP.get(id);
    }

    private static long getImageResById(int id) {
        switch (id) {
            case 0:
                return R.drawable.first_image;
            case 1:
                return R.drawable.cat1;
            default:
                return R.drawable.cat2;
        }
    }
}
