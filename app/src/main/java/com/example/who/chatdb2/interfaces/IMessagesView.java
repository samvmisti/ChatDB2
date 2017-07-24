package com.example.who.chatdb2.interfaces;

import android.content.Intent;

import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.pojo.Message;

import java.util.List;

/**
 * Created by who on 22.07.2017.
 */

public interface IMessagesView {
    void updateAdapter();

    void onBack();

    void setDataToAdapter(List<Message> data);

    void takePhoto(Intent intent, int chooseOpenPhoto);
}
