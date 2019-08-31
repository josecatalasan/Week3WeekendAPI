package com.example.week3weekendapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity /*implements HttpUrlConnectionHelper.HttpCallback*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ProfileAsyncTask profileAsyncTask = new ProfileAsyncTask();
        try {
            String json = profileAsyncTask.execute().get();
            System.out.println(json);
            Log.d("TAG", json);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
