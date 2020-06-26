package com.Monett.mureokmureok;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.Monett.mureokmureok.Data.DataManager;
import com.Monett.mureokmureok.Data.Diary;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new SplashHandler(), 3000);

        for (int i = 0; i < 10; i++) {
            Diary diary = new Diary("20200626", i+"번째");
            diary.setImage(((BitmapDrawable)getResources().getDrawable(R.drawable.splash_plant)).getBitmap());
            DataManager.getInstance(getApplicationContext()).getNewsfeedDiaries().add(diary);
        }

        Log.v("diary size", DataManager.getInstance(getApplicationContext()).getNewsfeedDiaries().size() + "" );
    }

    @Override
    public void onBackPressed() {

    }

    private class SplashHandler implements Runnable{
        public void run(){
            startActivity(new Intent(getApplication(), MainActivity.class));
            SplashActivity.this.finish();
        }
    }
}