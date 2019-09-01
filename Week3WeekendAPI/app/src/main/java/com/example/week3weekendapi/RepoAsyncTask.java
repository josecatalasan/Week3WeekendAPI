package com.example.week3weekendapi;

import android.os.AsyncTask;

import com.example.week3weekendapi.model.datasource.remote.HttpUrlConnectionHelper;
import com.example.week3weekendapi.model.profile.Profile;
import com.example.week3weekendapi.model.repos.Repository;
import com.google.gson.Gson;

import java.util.ArrayList;

public class RepoAsyncTask extends AsyncTask<Void, Void, ArrayList<Repository>> {

    String url;

    public RepoAsyncTask(String url) {
        super();
        this.url = url;
    }

    @Override
    protected ArrayList<Repository> doInBackground(Void... voids) {
        ArrayList<Repository> returnList = HttpUrlConnectionHelper.doRepoApiCall(url);
        return returnList;
    }
}
