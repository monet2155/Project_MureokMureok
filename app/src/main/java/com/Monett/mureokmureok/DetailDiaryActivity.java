package com.Monett.mureokmureok;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.Monett.mureokmureok.Data.DataManager;
import com.Monett.mureokmureok.Data.Diary;

public class DetailDiaryActivity extends AppCompatActivity {

    private TextView creationDateView;
    private TextView contentView;
    private TextView authorView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_diary);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().show();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initViews();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void initViews(){
        creationDateView = (TextView) findViewById(R.id.detail_diary_creationdate);
        contentView = (TextView) findViewById(R.id.detail_diary_content);
        authorView = (TextView) findViewById(R.id.detail_diary_author);
        imageView = (ImageView) findViewById(R.id.detail_diary_image);

        int position = getIntent().getIntExtra("diary_position", 0);
        Diary currentDiary = DataManager.getInstance(getApplicationContext()).getNewsfeedDiaries().get(position);

        creationDateView.setText(currentDiary.getCreationDate());
        contentView.setText(currentDiary.getContent());
        authorView.setText(currentDiary.getAuthor().getName());
        imageView.setImageBitmap(currentDiary.getImage());
    }
}