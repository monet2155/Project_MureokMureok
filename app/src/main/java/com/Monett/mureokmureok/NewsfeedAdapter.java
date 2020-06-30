package com.Monett.mureokmureok;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Monett.mureokmureok.CustomView.DiaryListView;
import com.Monett.mureokmureok.Data.DataManager;
import com.Monett.mureokmureok.Data.Diary;

public class NewsfeedAdapter extends RecyclerView.Adapter<NewsfeedAdapter.NewsfeedViewHolder> {

    Context mContext;

    public static class NewsfeedViewHolder extends RecyclerView.ViewHolder {

        public DiaryListView diaryView;

        public NewsfeedViewHolder(View v) {
            super(v);
            diaryView = (DiaryListView) v;
            diaryView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Intent intent = new Intent(v.getContext(), DetailDiaryActivity.class);
                    intent.putExtra("diary_position", position);

                    v.getContext().startActivity(intent);
                }
            });
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

        Diary currentDiary = DataManager.getInstance(mContext).getNewsfeedDiaries().get(position);

        String author = currentDiary.getAuthor().getName();
        ((TextView)(holder.diaryView).findViewById(R.id.diary_list_username)).setText(author);

        String content = currentDiary.getContent();
        ((TextView)(holder.diaryView.findViewById(R.id.diary_list_content))).setText(content);

        Bitmap image = currentDiary.getImage();
        ((ImageView)(holder.diaryView.findViewById(R.id.diary_list_image))).setImageBitmap(image);

    }

    @Override
    public int getItemCount() {
        return DataManager.getInstance(mContext).getNewsfeedDiaries().size();
    }
}
