package com.talgat.layoutcreatingtask2;

import java.util.Date;

public final class Note {

    private final int id;
    private final Date date;
    private final String text;
    private final String title;
    private final long drawableResId;

    Note(int id, Date date, String text, String title, long drawableIdRes) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.title = title;
        this.drawableResId = drawableIdRes;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public long getDrawableIdRes() {
        return drawableResId;
    }
}
