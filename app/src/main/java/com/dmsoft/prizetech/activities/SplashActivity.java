package com.dmsoft.prizetech.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.dmsoft.prizetech.R;

/**
 * Created by dev on 12/05/2017.
 */

public class SplashActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 2000);
    }

    @Override
    public void showSuccessNotificationBar(String message) {

    }

    @Override
    public void showErrorNotificationBar(String message) {

    }
}
