package com.Monett.mureokmureok;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DiaryListView extends LinearLayout {
    public TextView nameView;
    public TextView contentView;

    public ImageView imageView;

    public DiaryListView(Context context) {
        super(context);

        initView();
    }

    public DiaryListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initView();
    }

    public DiaryListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
    }

    private void initView(){

        inflate(getContext(), R.layout.diary_list_view, this);
        nameView = (TextView) findViewById(R.id.diary_username);
    }
}
