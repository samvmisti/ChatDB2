package com.example.who.chatdb2.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.who.chatdb2.R;
import com.example.who.chatdb2.adapters.MessagesListAdapter;
import com.example.who.chatdb2.interfaces.IMessagesView;
import com.example.who.chatdb2.pojo.Message;
import com.example.who.chatdb2.presenters.MessagesActivityPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by who on 21.07.2017.
 */

public class MessagesActivity extends AppCompatActivity implements IMessagesView {

    @BindView(R.id.lvMessages)
    ListView lvMessages;

    private MessagesListAdapter adapter;
    private MessagesActivityPresenter presenter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter = new MessagesActivityPresenter(getApplicationContext(), this);
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
