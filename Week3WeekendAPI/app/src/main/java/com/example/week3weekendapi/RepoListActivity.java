package com.example.week3weekendapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.week3weekendapi.model.datasource.remote.HttpUrlConnectionHelper;
import com.example.week3weekendapi.model.repos.Repository;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoListActivity extends AppCompatActivity {
    @BindView(R.id.rvRepoList)
    RecyclerView rvRepoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RepoAsyncTask repoAsyncTask = new RepoAsyncTask(HttpUrlConnectionHelper.MY_REPO_LIST);
        try {
            ArrayList<Repository> repoList = repoAsyncTask.execute().get();
            rvRepoList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            RecyclerView.Adapter adapter = new RepoListAdapter(repoList);
            rvRepoList.setAdapter(adapter);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
