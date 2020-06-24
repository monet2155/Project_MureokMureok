package com.Monett.mureokmureok;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsfeedAdapter extends RecyclerView.Adapter<NewsfeedAdapter.NewsfeedViewHolder> {

    Context mContext;

    public static class NewsfeedViewHolder extends RecyclerView.ViewHolder {

        public DiaryListView diaryView;

        public NewsfeedViewHolder(View v) {
            super(v);
            diaryView = (DiaryListView) v;
        }

        public DiaryListView getDiaryView(){
            return diaryView;
        }

    }

    public NewsfeedAdapter() {

    }

    @Override
    public NewsfeedAdapter.NewsfeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();

        // Init CustomView
        DiaryListView v = (DiaryListView) new DiaryListView(parent.getContext());
        v.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        // Set Holder
        NewsfeedViewHolder vh = new NewsfeedViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(NewsfeedViewHolder holder, int position) {

        String content = DataManager.getInstance(mContext).newsfeedDiaries.get(position).content;
        ((TextView)(holder.diaryView.findViewById(R.id.diary_content))).setText(content);
    }

    @Override
    public int getItemCount() {
        return DataManager.getInstance(mContext).newsfeedDiaries.size();
    }
}
