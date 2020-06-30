package com.Monett.mureokmureok.Data;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Monett.mureokmureok.R;

public class Plant {

    String name;
    String waterTerm;
    String lastRepottingDate;

    Bitmap plantPicture;

    PlantView plantView;

    public Plant(String name, String waterTerm, String lastRepottingDate) {
        this.name = name;
        this.waterTerm = waterTerm;
        this.lastRepottingDate = lastRepottingDate;

        plantView = null;
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

    public void setPlantPicture(Bitmap plantPicture) {
        this.plantPicture = plantPicture;
    }

    public Bitmap getPlantPicture() {
        return plantPicture;
    }

    public View getView(){
        return plantView;
    }

    public View getView(Context context){
        if (plantView == null){
            plantView = new PlantView(context, this);
        }
        return plantView;
    }
}

class PlantView extends LinearLayout{
    Context context;

    Plant plant;

    ImageView imageView;
    TextView nameView;
    TextView waterTermView;
    TextView lastRepottingDateView;

    public PlantView(Context context, Plant plant) {
        super(context);

        this.context = context;
        this.plant = plant;

        init();
    }

    public PlantView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PlantView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.plant_list_view, this, true);

        imageView = (ImageView) view.findViewById(R.id.plant_image);
        imageView.setImageBitmap(plant.getPlantPicture());

        nameView = (TextView) view.findViewById(R.id.plant_name);
        nameView.setText(plant.getName());

        waterTermView = (TextView) view.findViewById(R.id.plant_waterterm);
        waterTermView.setText(plant.getWaterTerm());

        lastRepottingDateView = (TextView) view.findViewById(R.id.plant_lastrepotting_date);
        lastRepottingDateView.setText(plant.getLastRepottingDate());

    }
}