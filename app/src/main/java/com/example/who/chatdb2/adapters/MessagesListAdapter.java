package com.example.who.chatdb2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.pojo.Message;
import com.example.who.chatdb2.views.ChannelsItemView;
import com.example.who.chatdb2.views.MessagesItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by who on 22.07.2017.
 */

public class MessagesListAdapter extends BaseAdapter {

    private Context context;
    private List<Message> data = new ArrayList<>();
    private LayoutInflater mInflater;

    public MessagesListAdapter(Context context, List<Message> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Message getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MessagesItemView itemView = (MessagesItemView) convertView;
        if (itemView == null) {
            itemView = MessagesItemView.inflate(parent);
        }
        updateView(itemView, position);

        return itemView;
    }

    private void updateView(MessagesItemView itemView, int position) {
        itemView.setOnClickListener(null);
        Message model = getItem(position);
        itemView.setItem(model);

    }
}