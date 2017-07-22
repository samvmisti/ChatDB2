package com.example.who.chatdb2.presenters;


import android.content.Context;
import android.util.Log;

import com.example.who.chatdb2.controller.RestManager;
import com.example.who.chatdb2.interfaces.IChannelsView;
import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.pojo.Channels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by who on 21.07.2017.
 */

public class ChannelFragmentPresenter {

    public static final String TAG = ChannelFragmentPresenter.class.getSimpleName();

    private List<Channel> data = new ArrayList<>();

    private Context mContext;
    private IChannelsView view;
    private Channel mChannel;
    private RestManager mManager;

    public ChannelFragmentPresenter(Context context, IChannelsView view) {
        this.mContext = context;
        this.view = view;
        mManager = new RestManager();
        initList();
    }

    private void initList() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("iostest", "iostest2k17!");
        Call<Channels> listCall = RestManager.createService(headers).getChannels("Basic aW9zdGVzdDppb3N0ZXN0MmsxNyE=");
        listCall.enqueue(new Callback<Channels>() {
            @Override
            public void onResponse(Call<Channels> call, Response<Channels> response) {
                data = response.body().getChannels();
                view.setDataToAdapter(data);
            }

            @Override
            public void onFailure(Call<Channels> call, Throwable t) {
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

    }

}
