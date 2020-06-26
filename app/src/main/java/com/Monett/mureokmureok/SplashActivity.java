package com.Monett.mureokmureok;

import android.content.Intent;
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

        for (int i = 0; i < 20; i++) {
            Diary diary = new Diary();
            diary.content = i + "번째";
            DataManager.getInstance(getApplicationContext()).newsfeedDiaries.add(diary);
        }

        Log.v("diary size", DataManager.getInstance(getApplicationContext()).newsfeedDiaries.size() + "" );
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