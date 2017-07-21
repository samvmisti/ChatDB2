package com.example.who.chatdb2.callback;

import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.pojo.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by who on 21.07.2017.
 */

public interface ChatService {

    @GET("/api/chat/channels/")
    Call<List<Channel>> getChannels();

    @GET("api/chat/channels/1/messages/")
    Call<Message> getMessages();
}
