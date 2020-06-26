package com.Monett.mureokmureok.Data;

import java.util.ArrayList;

public class User {

    String name;

    ArrayList<Plant> plants;
    ArrayList<Diary> diaries;

    public User(String name) {
        this.name = name;
        this.plants = new ArrayList<Plant>();
        this.diaries = new ArrayList<Diary>();
    }
}
