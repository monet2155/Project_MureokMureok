package com.Monett.mureokmureok;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.Monett.mureokmureok.Data.DataManager;
import com.Monett.mureokmureok.Data.Diary;
import com.Monett.mureokmureok.Data.User;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new SplashHandler(), 3000);

        // If Login
        User currentUser = new User("JunHyeok");
        DataManager.getInstance(getApplicationContext(), currentUser);

        for (int i = 0; i < 3; i++) {
            User user = new User("user" + i);
            for (int j = 0; j < 2; j++) {
                Diary diary = new Diary("20200626", user, "content" + j);
                diary.setImage(((BitmapDrawable)getResources().getDrawable(R.drawable.splash_plant)).getBitmap());

                user.getDiaries().add(diary);
            }
            DataManager.getInstance(getApplicationContext()).getNewsfeedDiaries().addAll(user.getDiaries());
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