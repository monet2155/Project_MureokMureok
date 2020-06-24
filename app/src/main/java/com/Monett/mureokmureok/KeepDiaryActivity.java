package com.Monett.mureokmureok;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class KeepDiaryActivity extends AppCompatActivity {

    EditText diaryContent;
    ImageButton diaryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_diary);

        Button saveButton = (Button) findViewById(R.id.save_diary_button);
        saveButton.setOnClickListener(new SaveButtonListner());

        diaryContent = (EditText) findViewById(R.id.keep_diary_content);
        diaryImage = (ImageButton) findViewById(R.id.keep_diary_image);
    }

    class SaveButtonListner implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Diary diary = new Diary();

            diary.content = diaryContent.getText().toString();

            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());

            diary.creationDate = format.format(today);

            Drawable image = diaryImage.getDrawable();
            diary.image = ((BitmapDrawable) image).getBitmap();

            DataManager.getInstance(getApplicationContext()).newsfeedDiaries.add(0,diary);

            finish();
        }
    }
}