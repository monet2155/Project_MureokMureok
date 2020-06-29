package com.Monett.mureokmureok;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.Monett.mureokmureok.Data.DataManager;
import com.Monett.mureokmureok.Data.Diary;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class KeepDiaryActivity extends AppCompatActivity {

    EditText diaryContent;
    ImageButton diaryImage;

    private static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_diary);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().show();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initViews();

    }

    private void initViews(){
        Button saveButton = (Button) findViewById(R.id.save_diary_button);
        saveButton.setOnClickListener(new SaveButtonListner());

        diaryContent = (EditText) findViewById(R.id.keep_diary_content);
        diaryImage = (ImageButton) findViewById(R.id.keep_diary_image);
        diaryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                try{
                    InputStream inputStream = getContentResolver().openInputStream(data.getData());
                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();

                    diaryImage.setImageBitmap(image);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_SHORT).show();
            }
        }
    }

    class SaveButtonListner implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            String content = diaryContent.getText().toString();

            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());

            String creationDate = format.format(today);

            Bitmap image =  ((BitmapDrawable) diaryImage.getDrawable()).getBitmap();

            Diary diary = new Diary(creationDate, DataManager.getInstance(getApplicationContext()).getCurrentUser(), content);
            diary.setImage(image);

            DataManager.getInstance(getApplicationContext()).getCurrentUser().getDiaries().add(diary);
            DataManager.getInstance(getApplicationContext()).getNewsfeedDiaries().add(0,diary);

            finish();
        }
    }
}