package com.example.week3weekendapi;

import android.os.AsyncTask;
import com.example.week3weekendapi.model.datasource.remote.HttpUrlConnectionHelper;
import com.example.week3weekendapi.model.profile.Profile;

public class ProfileAsyncTask extends AsyncTask<Void, Void, Profile> {

    private final String url;

    protected ProfileAsyncTask(String url) {
        super();
        this.url = url;
    }

    @Override
    protected Profile doInBackground(Void... voids) {
        return HttpUrlConnectionHelper.doProfileApiCall(url);
    }
}
