package com.Monett.mureokmureok;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.Monett.mureokmureok.Data.DataManager;

public class MainActivity extends AppCompatActivity {

    NewsfeedAdapter newsfeedAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init Newsfeed View
        recyclerView  = (RecyclerView) findViewById(R.id.newsfeed_recyclerview);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        newsfeedAdapter = new NewsfeedAdapter();
        recyclerView.setAdapter(newsfeedAdapter);

        // If Login
        Toast.makeText(this, DataManager.getInstance(getApplicationContext()).getCurrentUser().getName() + "님이 로그인 하셨습니다.",
                Toast.LENGTH_SHORT).show();

        // Init FloatingActionButton
        FloatingActionButton fab = findViewById(R.id.keep_diary_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KeepDiaryActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        newsfeedAdapter.notifyDataSetChanged();

        recyclerView.smoothScrollToPosition(0);
    }
}