package com.example.who.chatdb2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.views.ChannelsItemView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by who on 21.07.2017.
 */

public class ChannelsListAdapter extends BaseAdapter {

    private Context context;
    private List<Channel> data = new ArrayList<>();
    private LayoutInflater mInflater;

    public ChannelsListAdapter(Context context, List<Channel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Channel getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChannelsItemView itemView = (ChannelsItemView) convertView;
        if (itemView == null) {
            itemView = ChannelsItemView.inflate(parent);
        }
        updateView(itemView, position);

        return itemView;
    }

    private void updateView(ChannelsItemView itemView, int position) {
        itemView.setOnClickListener(null);
        Channel model = getItem(position);
        itemView.setItem(model);

    }
}
