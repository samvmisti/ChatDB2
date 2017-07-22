package com.example.who.chatdb2.presenters;

import android.content.Context;
import android.util.Log;

import com.example.who.chatdb2.controller.RestManager;
import com.example.who.chatdb2.interfaces.IMessagesView;
import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.pojo.Message;
import com.example.who.chatdb2.pojo.Messages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by who on 21.07.2017.
 */

public class MessagesActivityPresenter {

    public static final String TAG = ChannelFragmentPresenter.class.getSimpleName();

    private List<Message> data = new ArrayList<>();

    private Context mContext;
    private IMessagesView view;
    private Channel mChannel;
    private RestManager mManager;

    public MessagesActivityPresenter(Context context, IMessagesView view) {
        this.mContext = context;
        this.view = view;
        mManager = new RestManager();
        initList();
    }

    private void initList() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("iostest", "iostest2k17!");
        Call<Messages> listCall = RestManager.createService(headers).getMessages("Basic aW9zdGVzdDppb3N0ZXN0MmsxNyE=");
        listCall.enqueue(new Callback<Messages>() {
            @Override
            public void onResponse(Call<Messages> call, Response<Messages> response) {
                data = response.body().getMessages();
                view.setDataToAdapter(data);
            }

            @Override
            public void onFailure(Call<Messages> call, Throwable t) {
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }

}