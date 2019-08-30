package com.example.week3weekendapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.week3weekendapi.model.datasource.remote.HttpUrlConnectionHelper;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements HttpUrlConnectionHelper.HttpCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread networkThread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    HttpUrlConnectionHelper.doApiCall(MainActivity.this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        networkThread.start();
//        TextView test = findViewById(R.id.tvTest);
//        test.setText("IM HERE");
    }

    @Override
    public void onHttpUrlConnectionResponse(String json) {
        Log.d("TAG", json);
        System.out.println(json);
    }
}
