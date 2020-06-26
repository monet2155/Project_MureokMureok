package com.Monett.mureokmureok.Data;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Diary {
    String creationDate;
    String content;

    Bitmap image;

    public Diary(String creationDate, String content) {
        this.creationDate = creationDate;
        this.content = content;
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
