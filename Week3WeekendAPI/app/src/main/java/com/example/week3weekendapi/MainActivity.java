package com.example.week3weekendapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.week3weekendapi.model.datasource.remote.HttpUrlConnectionHelper;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements HttpUrlConnectionHelper.HttpCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread networkThread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    HttpUrlConnectionHelper.getRandomUsers(MainActivity.this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        networkThread.start();
    }

    @Override
    public void onHttpUrlConnectionResponse(String json) {

    }
}
