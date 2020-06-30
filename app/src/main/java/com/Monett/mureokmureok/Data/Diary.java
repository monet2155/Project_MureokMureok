package com.Monett.mureokmureok.Data;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Monett.mureokmureok.DetailDiaryActivity;
import com.Monett.mureokmureok.R;

import java.util.ArrayList;

public class Diary {
    String creationDate;
    User author;
    String content;

    Bitmap image;

    DiaryView diaryView;

    public Diary(String creationDate, User author, String content) {
        this.creationDate = creationDate;
        this.author = author;
        this.content = content;

        diaryView = null;
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

    public View getView(){
        return diaryView;
    }

    public View getView(Context context){
        if (diaryView == null){
            diaryView = new DiaryView(context, this);
        }
        return diaryView;
    }
}

class DiaryView extends LinearLayout {
    Context context;

    Diary diary;

    ImageView imageView;
    TextView nameView;
    TextView contentView;

    public DiaryView(Context context, Diary diary) {
        super(context);

        this.context = context;
        this.diary = diary;

        init();
    }

    public DiaryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DiaryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.diary_list_view, this, true);

        imageView = (ImageView) view.findViewById(R.id.diary_list_image);
        imageView.setImageBitmap(diary.getImage());

        nameView = (TextView) view.findViewById(R.id.diary_list_username);
        nameView.setText(diary.author.getName());

        contentView = (TextView) view.findViewById(R.id.diary_list_content);
        contentView.setText(diary.getContent());

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailDiaryActivity.class);

                int position = DataManager.getInstance(v.getContext()).newsfeedDiaries.indexOf(diary);
                intent.putExtra("diary_position", position);

                v.getContext().startActivity(intent);
            }
        });
    }
}
