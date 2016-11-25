package com.example.admin.recyclerview_example;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Admin on 24.11.2016.
 */

public class SergRecycler extends RecyclerView {

    private static final String TAG = "rv";
    View.OnClickListener onClickListener;

    public OnClickListener getOnClickListener() {
        return onClickListener;
    }

    @Override
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public SergRecycler(Context context) {
        super(context);
    }

    public SergRecycler(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SergRecycler(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public ViewHolder getChildViewHolder(View child) {
        Log.d(TAG,"public ViewHolder getChildViewHolder(View child): " + child);
        //child.setOnClickListener(onClickListener);
        return super.getChildViewHolder(child);
    }

    @Override
    public void onChildAttachedToWindow(View child) {
        Log.d(TAG,"onChildAttachedToWindow(View child): " + child);
        super.onChildAttachedToWindow(child);
    }

    @Override
    public long getChildItemId(View child) {
        Log.d(TAG,"getChildItemId(View child): " + child);
        return super.getChildItemId(child);
    }

    @Override
    public ViewHolder findViewHolderForLayoutPosition(int position) {
        Log.d(TAG,"findViewHolderForLayoutPosition(int position): " + position);
        return super.findViewHolderForLayoutPosition(position);
    }

    @Override
    public ViewHolder findViewHolderForAdapterPosition(int position) {
        Log.d(TAG,"findViewHolderForAdapterPosition(int position): " + position);
        return super.findViewHolderForAdapterPosition(position);
    }

    @Override
    public ViewHolder findViewHolderForItemId(long id) {
        Log.d(TAG,"findViewHolderForItemId(long id): " + id);
        return super.findViewHolderForItemId(id);
    }
}
