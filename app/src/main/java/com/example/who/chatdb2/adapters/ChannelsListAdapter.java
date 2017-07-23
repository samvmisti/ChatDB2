package com.example.who.chatdb2.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.who.chatdb2.R;
import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.views.ChannelsItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by who on 21.07.2017.
 */

public class ChannelsListAdapter extends RecyclerView.Adapter<ChannelsListAdapter.MyViewHolder> {

    private Context context;
    private List<Channel> data = new ArrayList<>();

    public ChannelsListAdapter(Context context, List<Channel> data) {
        this.context = context;
        this.data = data;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ChannelsItemView itemView;

        public MyViewHolder(View view) {
            super(view);
            itemView = (ChannelsItemView) view;
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        updateView(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ChannelsItemView itemView = (ChannelsItemView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.channels_item, parent, false);
        return new MyViewHolder(itemView);
    }

    private void updateView(ChannelsItemView itemView, int position) {
        Channel model = getItem(position);
        itemView.setItem(model);
    }

    public Channel getItem(int position) {
        return data.get(position);
    }
}