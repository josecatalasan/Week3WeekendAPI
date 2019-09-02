package com.example.week3weekendapi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.week3weekendapi.model.datasource.remote.HttpUrlConnectionHelper;
import com.example.week3weekendapi.model.profile.Profile;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;
import java.util.concurrent.ExecutionException;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvCompany)
    TextView tvCompany;
    @BindView(R.id.tvBio)
    TextView tvBio;
    @BindView(R.id.tvId)
    TextView tvId;
    @BindView(R.id.tvLogin)
    TextView tvLogin;
    @BindView(R.id.tvGitUrl)
    TextView tvGitUrl;
    @BindView(R.id.ivAvatar)
    ImageView ivAvatar;
    @BindView(R.id.fabRepoList)
    FloatingActionButton fabRepoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fabRepoList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RepoListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ProfileAsyncTask profileAsyncTask = new ProfileAsyncTask(HttpUrlConnectionHelper.MY_USER_PROFILE);
        try {
            Profile myProfile = profileAsyncTask.execute().get();
            //set view with Profile Object
            tvName.setText(myProfile.getName());
            tvCompany.setText(myProfile.getCompany());
            tvBio.setText(myProfile.getBio());
            tvId.setText(String.valueOf(myProfile.getId()));
            tvLogin.setText(myProfile.getLogin());
            tvGitUrl.setText(myProfile.getHtmlUrl());
            Picasso.get().load(myProfile.getAvatarUrl()).into(ivAvatar);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
