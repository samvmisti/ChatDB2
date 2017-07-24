package com.example.who.chatdb2.presenters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

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

import static com.example.who.chatdb2.global.Constants.CHOOSE_OPEN_PHOTO;

/**
 * Created by who on 21.07.2017.
 */

public class MessagesActivityPresenter {

    public static final String TAG = ChannelFragmentPresenter.class.getSimpleName();

    private List<Message> data = new ArrayList<>();
    private List<Message> sortedData = new ArrayList<>();
    private Context mContext;
    private IMessagesView view;
    private Channel mChannel;
    private RestManager mManager;
    private int senderID;

    public MessagesActivityPresenter(Context context, IMessagesView view, int senderID) {
        this.mContext = context;
        this.view = view;
        this.senderID = senderID;
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
                if (response.body() != null) {
                    data = response.body().getMessages();
                    sortedData = new ArrayList<>();
                    for (Message mes : data) {
                        if (mes.getSender().getId() == senderID) sortedData.add(mes);
                    }
                    view.setDataToAdapter(sortedData);
                }
            }

            @Override
            public void onFailure(Call<Messages> call, Throwable t) {
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }

    public void takePhotoFromSD() {
        String strManufacturer = android.os.Build.MANUFACTURER;
        Intent intent;
        if (strManufacturer.equals("samsung")) {
            intent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
            intent.putExtra("CONTENT_TYPE", "image/*");
            intent.addCategory(Intent.CATEGORY_DEFAULT);
        } else {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
        }
        view.takePhoto(intent, CHOOSE_OPEN_PHOTO);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CHOOSE_OPEN_PHOTO) {
            if (resultCode == Activity.RESULT_OK) {
                Uri imageUri = data.getData();
                Toast.makeText(mContext, "Your image URI \n" + imageUri.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}