package com.dmsoft.prizetech;


import android.app.Application;
import android.util.Log;

import com.snappydb.DB;
import com.snappydb.SnappyDB;
import com.snappydb.SnappydbException;


public class App extends Application {

    private static App instance;

    private DB db;

    public App() {
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        configureDatabase();
    }

    private void configureDatabase() {
        try {
            db = new SnappyDB.Builder(this)
                    //.directory(Environment.getExternalStorageDirectory().getAbsolutePath()) //optional
                    .name("prezetech_db")//optional
                    .build();
        } catch (SnappydbException e) {
            Log.e(e.getLocalizedMessage(), "Unable to create database");
        }
    }

    public DB getDb() {
        return db;
    }

}
