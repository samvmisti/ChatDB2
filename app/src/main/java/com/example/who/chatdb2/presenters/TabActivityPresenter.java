package com.example.who.chatdb2.presenters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;

import com.example.who.chatdb2.R;

import q.rorbin.badgeview.QBadgeView;

/**
 * Created by who on 22.07.2017.
 */

public class TabActivityPresenter {

    Context context;

    public TabActivityPresenter(Context context) {
        this.context = context;
    }

    public void setBadgeCountChat(int count, View v) {
        QBadgeView badgeView = new QBadgeView(context);
        badgeView.bindTarget(v);
        badgeView.setBadgeNumber(count);
        badgeView.setBadgeBackground(ContextCompat.getDrawable(context, R.drawable.circle_counter));
        badgeView.setShowShadow(true);
        badgeView.setBadgeTextSize(10, true);
        badgeView.setBadgeGravity(Gravity.CENTER | Gravity.START);
        badgeView.setGravityOffset(100, 0, true);
        badgeView.setBadgeTextColor(Color.WHITE);
    }

    public void setBadgeCountLiveChat(int count, View v) {
        QBadgeView badgeView = new QBadgeView(context);
        badgeView.bindTarget(v);
        badgeView.setBadgeNumber(count);
        badgeView.setBadgeBackground(ContextCompat.getDrawable(context, R.drawable.circle_counter_grey));
        badgeView.setShowShadow(true);
        badgeView.setBadgeTextSize(10, true);
        badgeView.setBadgeGravity(Gravity.CENTER | Gravity.END);
        badgeView.setGravityOffset(15, 0, true);
        badgeView.setBadgeTextColor(context.getColor(R.color.colorBadgeGreyFont));
    }
}
