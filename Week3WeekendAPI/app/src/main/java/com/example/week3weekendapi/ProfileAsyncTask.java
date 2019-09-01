package com.example.week3weekendapi;

import android.os.AsyncTask;

import com.example.week3weekendapi.model.datasource.remote.HttpUrlConnectionHelper;
import com.example.week3weekendapi.model.profile.Profile;
import com.google.gson.Gson;

public class ProfileAsyncTask extends AsyncTask<Void, Void, Profile> {
    String url;

    public ProfileAsyncTask(String url) {
        super();
        this.url = url;
    }

    @Override
    protected Profile doInBackground(Void... voids) {
        String json = HttpUrlConnectionHelper.doProfileApiCall(url);
        Gson gson = new Gson();
        Profile returnProfile = gson.fromJson(json, Profile.class);
        return returnProfile;
    }
}
