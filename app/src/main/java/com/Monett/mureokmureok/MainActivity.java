package com.Monett.mureokmureok;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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