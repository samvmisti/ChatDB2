package com.example.who.chatdb2.callback;

import com.example.who.chatdb2.pojo.Channels;
import com.example.who.chatdb2.pojo.Massages;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by who on 21.07.2017.
 */

public interface ChatService {

    @GET("api/chat/channels/")
    Call<Channels> getChannels();

    @GET("api/chat/channels/1/messages/")
    Call<Massages> getMessages();
}
