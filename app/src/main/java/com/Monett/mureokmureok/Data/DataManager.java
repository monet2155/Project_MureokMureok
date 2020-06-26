package com.Monett.mureokmureok.Data;

import android.content.Context;

import java.util.ArrayList;

public class DataManager {

    private static DataManager instance;

    ArrayList<User> users;
    ArrayList<Diary> newsfeedDiaries;

    public DataManager(){
        // DB Init

        users = new ArrayList<User>();
        newsfeedDiaries = new ArrayList<Diary>();
    }

    public static DataManager getInstance(Context context){
        if (instance == null){
            instance = new DataManager();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Diary> getNewsfeedDiaries() {
        return newsfeedDiaries;
    }
}
