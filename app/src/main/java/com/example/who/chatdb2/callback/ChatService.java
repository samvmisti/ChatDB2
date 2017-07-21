package com.example.who.chatdb2.callback;

import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.pojo.Channels;
import com.example.who.chatdb2.pojo.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by who on 21.07.2017.
 */

public interface ChatService {

    @GET("?format=json")
    Call<Channels> getChannels(@Header("Authorization") String token);

    @GET("1/messages/?format=json")
    Call<Message> getMessages(@Header("Authorization") String token);
}
