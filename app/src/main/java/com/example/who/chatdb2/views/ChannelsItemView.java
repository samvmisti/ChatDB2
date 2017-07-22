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
import com.daimajia.swipe.SwipeLayout;
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
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by who on 21.07.2017.
 */

public class ChannelsItemView extends RelativeLayout {

    public static final String TAG = ChannelsItemView.class.getSimpleName();

    @BindView(R.id.rootSwipeLayout)
    SwipeLayout rootSwipeLayout;
    @BindView(R.id.rlBottomWrapper)
    RelativeLayout rlBottomWrapper;
    @BindView(R.id.ivChannelsContactProfile)
    CircleImageView ivChannelsContactProfile;
    @BindView(R.id.ivChannelsContactProfileBottom)
    CircleImageView ivChannelsContactProfileBottom;
    @BindView(R.id.tvChannelsContactName)
    TextView tvChannelsContactName;
    @BindView(R.id.tvChannelsContactNameBottom)
    TextView tvChannelsContactNameBottom;
    @BindView(R.id.tvChannelsContactLastMessage)
    TextView tvChannelsContactLastMessage;
    @BindView(R.id.tvChannelsContactLastMessageBottom)
    TextView tvChannelsContactLastMessageBottom;
    @BindView(R.id.tvChannelsTimeOfMessage)
    TextView tvChannelsTimeOfMessage;
    @BindView(R.id.tvChannelsContactCounterText)
    TextView tvChannelsContactCounterText;
    @BindView(R.id.ivChannelsContactCounter)
    CircleImageView ivChannelsContactCounter;


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
        Glide.with(getContext())
                .load(src)
                .into(ivChannelsContactProfileBottom);
    }

    void setUserName(String name) {
        tvChannelsContactName.setText(name);
        tvChannelsContactNameBottom.setText(name);
    }

    void setLastMessage(String message) {
        tvChannelsContactLastMessage.setText(message);
        tvChannelsContactLastMessageBottom.setText(message);
    }

    void setTimeOfMessage(String time) {
        tvChannelsTimeOfMessage.setText(time);
    }

    void setNumberUnread(int count) {
        if (count == 0) {
            tvChannelsContactCounterText.setVisibility(INVISIBLE);
            ivChannelsContactCounter.setVisibility(INVISIBLE);
        } else {
            tvChannelsContactCounterText.setVisibility(VISIBLE);
            ivChannelsContactCounter.setVisibility(VISIBLE);
            tvChannelsContactCounterText.setText(String.valueOf(count));
        }
    }

    public static ChannelsItemView inflate(ViewGroup parent) {
        ChannelsItemView itemView = (ChannelsItemView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.channels_item, parent, false);
        return itemView;
    }

    public void setItem(Channel item) {
        if (item != null) {
            rootSwipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
            rootSwipeLayout.addDrag(SwipeLayout.DragEdge.Left, rlBottomWrapper);
            setUserName("" + item.getLastMessage().getSender().getFirstName() + " " + item.getLastMessage().getSender().getLastName());
            setLastMessage("" + item.getLastMessage().getText());
            setNumberUnread(item.getUnreadMessagesCount());
            setUserImage(item.getLastMessage().getSender().getPhoto());
            String d = item.getLastMessage().getCreateDate();
            setTimeOfMessage(getNormalizedTime(d));
        }
    }

    private String getNormalizedTime(String oldTime) {
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat myFormat = new SimpleDateFormat("HH:mm");
        String reformattedStr = "";
        try {
            reformattedStr = myFormat.format(fromUser.parse(oldTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reformattedStr;
    }
}
