package com.dmsoft.prizetech.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dmsoft.prizetech.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.ll_main)
    LinearLayout llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void showSuccessNotificationBar(String message) {
        Snackbar snackbar = Snackbar.make(llMain, message, Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.LTGRAY);
        View snackBar = snackbar.getView();
        snackBar.setBackgroundResource(R.color.success_notification_bar);
        TextView textView = (TextView) snackBar.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(getResources().getColor(R.color.success_notification_bar_text));
        snackbar.show();
    }

    @Override
    public void showErrorNotificationBar(String message) {

        Snackbar snackbar = Snackbar.make(llMain, message, Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.LTGRAY);
        View snackBar = snackbar.getView();
        snackBar.setBackgroundResource(R.color.error_notification_bar);
        TextView textView = (TextView) snackBar.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(getResources().getColor(R.color.error_notification_bar_text));
        snackbar.show();

    }
}
