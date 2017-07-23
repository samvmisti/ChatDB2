package com.example.who.chatdb2.views;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daimajia.swipe.SwipeLayout;
import com.example.who.chatdb2.R;
import com.example.who.chatdb2.Utils.TimeUtils;
import com.example.who.chatdb2.pojo.Channel;
import com.example.who.chatdb2.ui.MessagesActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.who.chatdb2.global.Constants.SENDER_ID;
import static com.example.who.chatdb2.global.Constants.SENDER_NAME;
import static com.example.who.chatdb2.global.Constants.SENDER_PHOTO;

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
    @BindView(R.id.wrap)
    RelativeLayout wrap;

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

//    public static ChannelsItemView inflate(ViewGroup parent) {
//        ChannelsItemView itemView = (ChannelsItemView) LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.channels_item, parent, false);
//        return itemView;
//    }

    public void setItem(Channel item) {
        if (item != null) {
            final int senderID = item.getLastMessage().getSender().getId();
            final String senderName = "" + item.getLastMessage().getSender().getFirstName() + " " + item.getLastMessage().getSender().getLastName();
            final String senderPhoto = item.getLastMessage().getSender().getPhoto();
            rootSwipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
            rootSwipeLayout.addDrag(SwipeLayout.DragEdge.Left, rlBottomWrapper);
            rootSwipeLayout.setOnTouchListener(null);
            rootSwipeLayout.getSurfaceView().setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getContext(), MessagesActivity.class);
                    i.putExtra(SENDER_ID, senderID);
                    i.putExtra(SENDER_NAME, senderName);
                    i.putExtra(SENDER_PHOTO, senderPhoto);
                    getContext().startActivity(i);
                }
            });
            setUserName(senderName);
            setLastMessage("" + item.getLastMessage().getText());
            setNumberUnread(item.getUnreadMessagesCount());
            setUserImage(senderPhoto);
            String d = item.getLastMessage().getCreateDate();
            setTimeOfMessage(TimeUtils.getNormalizedTime(d));
        }
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
    }
}
