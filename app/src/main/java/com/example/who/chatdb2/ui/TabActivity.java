package com.example.who.chatdb2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.who.chatdb2.R;
import com.example.who.chatdb2.presenters.TabActivityPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by who on 22.07.2017.
 */

public class TabActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private Toolbar toolbar;
    public TabLayout tabLayout;
    private ViewPager viewPager;
    private TabActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity);
        presenter = new TabActivityPresenter(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.vpTabActivity);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tlTabActivity);
        tabLayout.setTabTextColors(getColor(R.color.colorTextUnelectedTab), getColor(R.color.colorTextSelectedTab));
        tabLayout.setupWithViewPager(viewPager);
        presenter.setBadgeCountLiveChat(15, tabLayout);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChannelsFragment(), getString(R.string.chat_tab));
        adapter.addFragment(new Fragment(), getString(R.string.live_chat_tab));
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        Intent intent = null;
        switch (itemId) {
            case android.R.id.home:
                intent = new Intent(TabActivity.this, EmptyActivityWithButton.class);
                startActivity(intent);
                break;

        } return true;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void goToEmptyActivity(MenuItem item) {
        Intent intent = new Intent(TabActivity.this, EmptyActivity.class);
        startActivity(intent);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Integer count) {
        presenter.setBadgeCountChat(count, tabLayout);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
