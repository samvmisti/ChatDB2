package com.example.who.chatdb2.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.who.chatdb2.R;
import com.example.who.chatdb2.adapters.ChannelsListAdapter;
import com.example.who.chatdb2.interfaces.IChannelsView;
import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.presenters.ChannelFragmentPresenter;

import java.util.List;
import butterknife.ButterKnife;

/**
 * Created by who on 21.07.2017.
 */

public class ChannelsFragment extends Fragment implements IChannelsView{

    ListView lvChannels;

    private ChannelsListAdapter adapter;
    private ChannelFragmentPresenter presenter;


    public ChannelsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.channels_fragment_layout, container, false);
        ButterKnife.bind(getActivity());
        lvChannels = (ListView) rootView.findViewById(R.id.list);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter = new ChannelFragmentPresenter(getActivity(), this);
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
        adapter = new ChannelsListAdapter(getActivity(), data);
        lvChannels.setAdapter(adapter);
    }
}
