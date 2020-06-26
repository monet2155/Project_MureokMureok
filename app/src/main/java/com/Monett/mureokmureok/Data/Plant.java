package com.Monett.mureokmureok.Data;

import android.content.res.TypedArray;

public class Plant {

    String name;
    String waterTerm;
    String lastRepottingDate;

    TypedArray plantPictures;

    public Plant(String name, String waterTerm, String lastRepottingDate) {
        this.name = name;
        this.waterTerm = waterTerm;
        this.lastRepottingDate = lastRepottingDate;
    }

    public String getName() {
        return name;
    }

    public String getWaterTerm() {
        return waterTerm;
    }

    public String getLastRepottingDate() {
        return lastRepottingDate;
    }

    public TypedArray getPlantPictures() {
        return plantPictures;
    }
}
