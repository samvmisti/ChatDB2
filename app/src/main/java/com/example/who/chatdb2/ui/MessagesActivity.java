package com.example.who.chatdb2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.who.chatdb2.R;
import com.example.who.chatdb2.adapters.MessagesListAdapter;
import com.example.who.chatdb2.interfaces.IMessagesView;
import com.example.who.chatdb2.pojo.Message;
import com.example.who.chatdb2.presenters.MessagesActivityPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.who.chatdb2.global.Constants.SENDER_ID;
import static com.example.who.chatdb2.global.Constants.SENDER_NAME;
import static com.example.who.chatdb2.global.Constants.SENDER_PHOTO;

/**
 * Created by who on 21.07.2017.
 */

public class MessagesActivity extends AppCompatActivity implements IMessagesView {

    @BindView(R.id.lvMessages)
    ListView lvMessages;

    private MessagesListAdapter adapter;
    private MessagesActivityPresenter presenter;
    private Toolbar toolbar;
    private int senderID;
    private String senderName;
    private String senderPhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages_activity);
        getIntentExtras();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setCurrentToolbar();
        ButterKnife.bind(this);
    }

    private void getIntentExtras() {
        Intent i = getIntent();
        if(i.hasExtra(SENDER_ID))senderID = i.getIntExtra(SENDER_ID, 0);
        if(i.hasExtra(SENDER_NAME))senderName = i.getStringExtra(SENDER_NAME);
        if(i.hasExtra(SENDER_PHOTO))senderPhoto = i.getStringExtra(SENDER_PHOTO);
    }

    private void setCurrentToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.titleview, null);
        TextView title = (TextView)v.findViewById(R.id.tvCustomTitle);
        if(!TextUtils.isEmpty(senderName))title.setText(senderName);
        getSupportActionBar().setCustomView(v);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter = new MessagesActivityPresenter(getApplicationContext(), this, senderID);
    }

    @Override
    public void updateAdapter() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBack() {
    }

    @Override
    public void setDataToAdapter(List<Message> data) {
        adapter = new MessagesListAdapter(this, data);
        lvMessages.setAdapter(adapter);
    }
}
