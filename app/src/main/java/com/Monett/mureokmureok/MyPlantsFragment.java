package com.Monett.mureokmureok;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.Monett.mureokmureok.Data.DataManager;
import com.Monett.mureokmureok.Data.Diary;
import com.Monett.mureokmureok.Data.Plant;

import java.util.ArrayList;

public class MyPlantsFragment extends Fragment {

    ViewGroup rootView;

    ArrayList<Plant> plants = DataManager.getInstance(getContext()).getCurrentUser().getPlants();
    PlantAdapter plantAdapter;

    public MyPlantsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_my_plants, container, false);

        initPlantsList();

        return rootView;
    }

    private void initPlantsList(){
        ListView plantsList = rootView.findViewById(R.id.myplants_list);
        plantAdapter = new PlantAdapter(getContext(), plants);

        plantsList.setAdapter(plantAdapter);
    }

    class PlantAdapter extends BaseAdapter{
        ArrayList<Plant> plants;
        Context context;

        public PlantAdapter(Context context, ArrayList<Plant> plants) {
            this.context = context;
            this.plants = plants;
        }

        @Override
        public int getCount() {
            return plants.size();
        }

        @Override
        public Object getItem(int position) {
            return plants.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = plants.get(position).getView();
            if (view == null){
                view = plants.get(position).getView(context);
            }
            return view;
        }
    }
}