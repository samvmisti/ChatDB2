package com.example.who.chatdb2.interfaces;

import com.example.who.chatdb2.pojo.Channel;

import java.util.List;

/**
 * Created by who on 21.07.2017.
 */

public interface IChannelsView {

    void updateAdapter();

    void onBack();

    void setDataToAdapter(List<Channel> data);
}
