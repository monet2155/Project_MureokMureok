package com.Monett.mureokmureok;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MyPageActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 2;

    private ViewPager mPager;
    private PagerAdapter pagerAdapter;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().show();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initFloatingActionButton();
        initViewPager();
    }

    private void initFloatingActionButton(){
        // Init FloatingActionButton
        fab = findViewById(R.id.keep_diary_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KeepDiaryActivity.class);
                startActivity(intent);
            }
        });

        fab.hide();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void initViewPager(){
        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyPageActivity.PagerAdapter(getSupportFragmentManager());

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        fab.hide();
                        break;
                    case 1:
                        fab.show();
                        break;
                    default:
                        fab.hide();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mPager.setAdapter(pagerAdapter);
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {
        MyPlantsFragment plantsFragment;
        MyDiariesFragment diariesFragment;

        public PagerAdapter(FragmentManager fm) {
            super(fm);
            plantsFragment = new MyPlantsFragment();
            diariesFragment = new MyDiariesFragment();
        }



        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return plantsFragment;
            } else if (position == 1){
                return diariesFragment;
            }
            return new MyPlantsFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}