package com.example.who.chatdb2.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.example.who.chatdb2.R;
import com.example.who.chatdb2.Utils.TimeUtils;
import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.pojo.Message;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by who on 22.07.2017.
 */

public class MessagesItemView extends RelativeLayout {

    @BindView(R.id.ivMessagesContactProfile)
    CircleImageView ivMessagesContactProfile;
    @BindView(R.id.rlMessageFromSender)
    RelativeLayout rlMessageFromSender;
    @BindView(R.id.tvMessageFromSender)
    TextView tvMessageFromSender;
    @BindView(R.id.rlMessageFromMe)
    RelativeLayout rlMessageFromMe;
    @BindView(R.id.tvMessageFromMe)
    TextView tvMessageFromMe;
    @BindView(R.id.tvMessageTime)
    TextView tvMessageTime;

    public MessagesItemView(Context context) {
        super(context);
        init();
    }

    public MessagesItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MessagesItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.messages_item_view, this);
        ButterKnife.bind(this);
        rlMessageFromMe.setVisibility(INVISIBLE);
    }

    void setMessageFromSender(String message){
        tvMessageFromSender.setText(message);
    }

    void setMessageFromMe(String message){
        tvMessageFromMe.setText(message);
    }

    void setTimeOfMessage(String time) {
        tvMessageTime.setText(time);
    }

    public static MessagesItemView inflate(ViewGroup parent) {
        MessagesItemView itemView = (MessagesItemView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.messages_item, parent, false);
        return itemView;
    }

    public void setItem(Message item) {
        if (item != null) {
            setMessageFromSender(item.getText());
            String d = item.getCreateDate();
            setTimeOfMessage(TimeUtils.getNormalizedTime(d));
        }
    }
}
