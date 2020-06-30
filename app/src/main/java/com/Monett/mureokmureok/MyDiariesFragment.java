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

public class MyDiariesFragment extends Fragment {

    ViewGroup rootView;

    ArrayList<Diary> diaries = DataManager.getInstance(getContext()).getCurrentUser().getDiaries();
    DiaryAdapter diaryAdapter;

    public MyDiariesFragment() {
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
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_my_diaries, container, false);

        initDiariesList();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        diaryAdapter.notifyDataSetChanged();
    }

    private void initDiariesList(){
        ListView diariesList = rootView.findViewById(R.id.mydiaries_list);
        diaryAdapter = new MyDiariesFragment.DiaryAdapter(getContext(), diaries);

        diariesList.setAdapter(diaryAdapter);
    }

    class DiaryAdapter extends BaseAdapter {
        ArrayList<Diary> diaries;
        Context context;

        public DiaryAdapter(Context context, ArrayList<Diary> diaries) {
            this.context = context;
            this.diaries = diaries;
        }

        @Override
        public int getCount() {
            return diaries.size();
        }

        @Override
        public Object getItem(int position) {
            return diaries.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = diaries.get(position).getView();
            if (view == null){
                view = diaries.get(position).getView(context);
            }
            return view;
        }
    }
}