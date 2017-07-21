package com.example.who.chatdb2.presenters;

import android.content.Context;
import android.util.Log;

import com.example.who.chatdb2.controller.RestManager;
import com.example.who.chatdb2.interfaces.IChannelsView;
import com.example.who.chatdb2.pojo.Channel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by who on 21.07.2017.
 */

public class ChannelActivityPresenter {

    public static final String TAG = ChannelActivityPresenter.class.getSimpleName();

    private List<Channel> data = new ArrayList<>();

    private Context mContext;
    private IChannelsView view;
    private Channel mChannel;
    private RestManager mManager;

    public ChannelActivityPresenter(Context context, IChannelsView view) {
        this.mContext = context;
        this.view = view;
        mManager = new RestManager();
        initList();
    }

    private void initList() {
        Call<List<Channel>> listCall = mManager.getChatService().getChannels();
        listCall.enqueue(new Callback<List<Channel>>() {
            @Override
            public void onResponse(Call<List<Channel>> call, Response<List<Channel>> response) {
                data = response.body();
            }

            @Override
            public void onFailure(Call<List<Channel>> call, Throwable t) {
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
//        data.add(0, new DayOfWeekModel(MONDAY));
//        data.add(1, new DayOfWeekModel(TUESDAY));
//        data.add(2, new DayOfWeekModel(WEDNESDAY));
//        data.add(3, new DayOfWeekModel(THURSDAY));
//        data.add(4, new DayOfWeekModel(FRIDAY));
//        data.add(5, new DayOfWeekModel(SATURDAY));
//        data.add(6, new DayOfWeekModel(SUNDAY));
        view.setDataToAdapter(data);
    }
}
