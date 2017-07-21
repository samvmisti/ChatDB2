package com.example.who.chatdb2.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ViewUtils;
import android.view.View;
import android.widget.ListView;

import com.example.who.chatdb2.R;
import com.example.who.chatdb2.adapters.ChannelsListAdapter;
import com.example.who.chatdb2.interfaces.IChannelsView;
import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.presenters.ChannelActivityPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by who on 21.07.2017.
 */

public class ChannelsActivity extends AppCompatActivity implements IChannelsView {

    @BindView(R.id.lvChannels)
    ListView lvChannels;

    private ChannelsListAdapter adapter;
    private ChannelActivityPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channels_activity);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter = new ChannelActivityPresenter(getApplicationContext(), this);
    }

    @Override
    public void updateAdapter() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBack() {

    }

    @Override
    public void setDataToAdapter(List<Channel> data) {
        adapter = new ChannelsListAdapter(this, data);
        lvChannels.setAdapter(adapter);
    }
}
