package com.example.week3weekendapi;

import android.os.AsyncTask;

import com.example.week3weekendapi.model.datasource.remote.HttpUrlConnectionHelper;

public class ProfileAsyncTask extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... strings) {
        return HttpUrlConnectionHelper.doApiCall();
    }
}
