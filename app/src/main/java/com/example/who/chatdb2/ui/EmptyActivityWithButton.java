package com.example.who.chatdb2.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.who.chatdb2.R;

/**
 * Created by who on 23.07.2017.
 */

public class EmptyActivityWithButton extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_activity_with_button);
    }

    public void goBack(View view) {
        onBackPressed();
    }
}