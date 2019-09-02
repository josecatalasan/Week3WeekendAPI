package com.example.week3weekendapi;

import android.os.AsyncTask;
import com.example.week3weekendapi.model.datasource.remote.HttpUrlConnectionHelper;
import com.example.week3weekendapi.model.repos.Repository;

import java.util.ArrayList;

public class RepoAsyncTask extends AsyncTask<Void, Void, ArrayList<Repository>> {

    private final String url;

    protected RepoAsyncTask(String url) {
        super();
        this.url = url;
    }

    @Override
    protected ArrayList<Repository> doInBackground(Void... voids) {
        return HttpUrlConnectionHelper.doRepoApiCall(url);
    }
}
