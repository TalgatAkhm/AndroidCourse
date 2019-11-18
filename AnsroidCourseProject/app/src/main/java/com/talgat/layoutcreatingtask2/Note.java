package com.talgat.layoutcreatingtask2;

import java.util.Date;

public final class Note {

    private final long id;
    private final Date date;
    private final String text;
    private final String title;
    private final int drawableResId;

    Note(long id, Date date, String text, String title, int drawableIdRes) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.title = title;
        this.drawableResId = drawableIdRes;
    }

    public long getId() {
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

    public int getDrawableIdRes() {
        return drawableResId;
    }
}
