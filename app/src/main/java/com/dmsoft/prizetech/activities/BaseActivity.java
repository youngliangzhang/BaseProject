package com.dmsoft.prizetech.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.dmsoft.prizetech.util.ProcessDialog;


public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    public void showProgressBar() {
        try{
            if (progressDialog != null && progressDialog.isShowing()){
                progressDialog.dismiss();
            }

            progressDialog = ProcessDialog.show(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void hideProgressBar() {
        try{
            if (progressDialog != null){
                progressDialog.dismiss();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean isProgressBarVisible(){
        if (progressDialog != null && progressDialog.isShowing()){
            return true;
        }else {
            return false;
        }
    }
    public abstract void showSuccessNotificationBar(String message);
    public abstract void showErrorNotificationBar(String message);

}
