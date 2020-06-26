package com.Monett.mureokmureok.Data;

import android.content.Context;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class DataManager {

    private static DataManager instance;

    User currentUser;

    ArrayList<User> users;
    ArrayList<Diary> newsfeedDiaries;

    public DataManager(@Nullable User currentUser){
        // DB Init
        if (currentUser != null){
            this.currentUser = currentUser;
        }

        users = new ArrayList<User>();
        newsfeedDiaries = new ArrayList<Diary>();
    }

    public static DataManager getInstance(Context context){
        if (instance == null){
            instance = new DataManager(null);
        }
        return instance;
    }

    public static DataManager getInstance(Context context, User currentUser){
        if (instance == null){
            instance = new DataManager(currentUser);
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Diary> getNewsfeedDiaries() {
        return newsfeedDiaries;
    }
}
