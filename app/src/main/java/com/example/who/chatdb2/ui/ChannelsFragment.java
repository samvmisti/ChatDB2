package com.example.who.chatdb2.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.who.chatdb2.R;
import com.example.who.chatdb2.adapters.ChannelsListAdapter;
import com.example.who.chatdb2.interfaces.IChannelsView;
import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.presenters.ChannelFragmentPresenter;

import java.util.List;

/**
 * Created by who on 21.07.2017.
 */

public class ChannelsFragment extends Fragment implements IChannelsView {

    RecyclerView rvChannelsFragment;

    private ChannelsListAdapter adapter;
    private ChannelFragmentPresenter presenter;


    public ChannelsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rvChannelsFragment = (RecyclerView) inflater.inflate(R.layout.channels_fragment_layout, container, false);
        rvChannelsFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rvChannelsFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter = new ChannelFragmentPresenter(getContext(), this);
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
        adapter = new ChannelsListAdapter(getContext(), data);
        rvChannelsFragment.setAdapter(adapter);
    }
}
