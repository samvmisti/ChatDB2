package com.example.who.chatdb2.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.who.chatdb2.R;
import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.pojo.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by who on 21.07.2017.
 */

public class ChannelsItemView extends RelativeLayout {

    public static final String TAG = ChannelsItemView.class.getSimpleName();

    @BindView(R.id.ivChannelsContactProfile)
    ImageView ivChannelsContactProfile;
    @BindView(R.id.tvChannelsContactName)
    TextView tvChannelsContactName;
    @BindView(R.id.tvChannelsContactLastMessage)
    TextView tvChannelsContactLastMessage;
    @BindView(R.id.tvChannelsTimeOfMessage)
    TextView tvChannelsTimeOfMessage;
    @BindView(R.id.tvChannelsContactCounterText)
    TextView tvChannelsContactCounterText;

    public ChannelsItemView(Context context) {
        super(context);
        init();
    }

    public ChannelsItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ChannelsItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.channels_item_view, this);
        ButterKnife.bind(this);
    }

    void setUserImage(String src) {
        Glide.with(getContext())
                .load(src)
                .into(ivChannelsContactProfile);
    }

    void setUserName(String name) {
        tvChannelsContactName.setText(name);
    }

    void setLastMessage(String message) {
        tvChannelsContactLastMessage.setText(message);
    }

    void setTimeOfMessage(String time) {
        tvChannelsTimeOfMessage.setText(time);
    }

    void setNumberUnread(int count) {
        tvChannelsContactCounterText.setText(String.valueOf(count));
    }

    public static ChannelsItemView inflate(ViewGroup parent) {
        ChannelsItemView itemView = (ChannelsItemView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.channels_item, parent, false);
        return itemView;
    }

    public void setItem(Channel item) {
        if (item != null) {
            setUserName("" + item.getLastMessage().getSender().getFirstName() + " " + item.getLastMessage().getSender().getLastName());
        }
        setLastMessage("" + item.getLastMessage().getText());
        String format = "EEE, dd MMM yyyy HH:mm:ss z";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        try {
            Date result = sdf.parse(item.getLastMessage().getCreateDate());
            setTimeOfMessage("" + result);
        } catch (ParseException ex) {
            Log.d(TAG, ex.getLocalizedMessage());
        }
        setNumberUnread(item.getUnreadMessagesCount());
    }
}