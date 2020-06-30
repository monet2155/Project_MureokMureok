package com.Monett.mureokmureok;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.Monett.mureokmureok.Data.DataManager;
import com.Monett.mureokmureok.Data.Diary;
import com.Monett.mureokmureok.Data.Plant;
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
        for (int i = 0; i < 2; i++) {
            Plant plant = new Plant("plant" + i, "3일에 1번", "20200620");
            plant.setPlantPicture(((BitmapDrawable)getResources().getDrawable(R.drawable.splash_plant)).getBitmap());
            currentUser.getPlants().add(plant);
        }
        DataManager.getInstance(getApplicationContext(), currentUser);

        getDataOnServer();
    }

    private void getDataOnServer(){
        for (int i = 0; i < 3; i++) {
            User user = new User("user" + i);
            for (int j = 0; j < 2; j++) {
                Diary diary = new Diary("20200626", user, "content" + j);
                diary.setImage(((BitmapDrawable)getResources().getDrawable(R.drawable.splash_plant)).getBitmap());

                user.getDiaries().add(diary);
            }
            DataManager.getInstance(getApplicationContext()).getNewsfeedDiaries().addAll(user.getDiaries());
        }
    }

    @Override
    public void onBackPressed() {
        // Don't go back
    }

    private class SplashHandler implements Runnable{
        public void run(){
            startActivity(new Intent(getApplication(), MainActivity.class));
            SplashActivity.this.finish();
        }
    }
}