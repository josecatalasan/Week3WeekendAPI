package com.example.week3weekendapi;

import android.os.AsyncTask;

import com.example.week3weekendapi.model.datasource.remote.HttpUrlConnectionHelper;

public class ProfileAsyncTask extends AsyncTask<Void, Void, String> {
    String url;

    public ProfileAsyncTask(String url) {
        super();
        this.url = url;
    }

    @Override
    protected String doInBackground(Void... voids) {
        return HttpUrlConnectionHelper.doApiCall(url);
    }
}
