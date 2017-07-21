package com.example.who.chatdb2.controller;

import com.example.who.chatdb2.callback.ChatService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by who on 21.07.2017.
 */

public class RestManager {

    ChatService mChatService;

    public ChatService getChatService() {
        if (mChatService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://iostest.db2dev.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mChatService = retrofit.create(ChatService.class);
        }

        return mChatService;
    }
}
