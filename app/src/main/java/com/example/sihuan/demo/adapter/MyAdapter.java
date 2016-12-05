package com.example.sihuan.demo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sihuan.demo.R;
import com.example.sihuan.demo.ScrollingActivity;

import java.util.List;


/**
 * Created by sihuan on 2016/12/5.
 * com.example.sihuan.demo.adapter
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<String> mData;
    Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.getTextView().setText("这是第" + position + "个,数据是" + mData.get(position));
        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity((Activity) context, holder.getImageView());
            }
        });
//        holder.getImageView().setImageResource();
    }

    public static void startActivity(Activity activity, ImageView showImage) {
        Intent intent = new Intent();
        intent.setClass(activity, ScrollingActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(activity, showImage, "sihuan");
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setmData(List list) {
        mData = list;
        notifyDataSetChanged();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        View itemView;

        MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            textView = (TextView) itemView.findViewById(R.id.tv);
            imageView = (ImageView) itemView.findViewById(R.id.iv);
        }

        ImageView getImageView() {
            return imageView;
        }

        TextView getTextView() {
            return textView;
        }

        public View getItemView() {
            return itemView;
        }
    }
}
