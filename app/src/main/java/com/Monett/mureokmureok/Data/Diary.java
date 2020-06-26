package com.Monett.mureokmureok.Data;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Diary {
    String creationDate;
    User author;
    String content;

    Bitmap image;

    public Diary(String creationDate, User author, String content) {
        this.creationDate = creationDate;
        this.author = author;
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getContent() {
        return content;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
