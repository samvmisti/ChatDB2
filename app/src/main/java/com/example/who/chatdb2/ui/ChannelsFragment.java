package com.example.who.chatdb2.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

public class ChannelsFragment extends Fragment implements IChannelsView {

//    @BindView(R.id.lvChannels)
    ListView lvChannels;

    private ChannelsListAdapter adapter;
    private ChannelFragmentPresenter presenter;

    public ChannelsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.channels_fragment_layout, container, false);
        lvChannels = (ListView) rootView.findViewById(R.id.lvChannels);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(getActivity());
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
        adapter = new ChannelsListAdapter(getContext(), data);
        lvChannels.setAdapter(adapter);
    }
}
