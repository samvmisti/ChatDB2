package com.example.who.chatdb2.controller;


import com.example.who.chatdb2.callback.ChatService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by who on 21.07.2017.
 */

public class RestManager {

    ChatService mChatService;


    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(getClient()).build();

    public ChatService getChatService() {
        if (mChatService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://iostest.db2dev.com/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mChatService = retrofit.create(ChatService.class);
        }

        return mChatService;
    }

    private HttpLoggingInterceptor getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

}
