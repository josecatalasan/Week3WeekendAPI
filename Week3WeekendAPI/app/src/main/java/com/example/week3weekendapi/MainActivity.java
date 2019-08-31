package com.example.week3weekendapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.week3weekendapi.model.profile.Profile;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity /*implements HttpUrlConnectionHelper.HttpCallback*/ {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ProfileAsyncTask profileAsyncTask = new ProfileAsyncTask();
        try {
            //start AsyncTask and save JSon response to string
            String json = profileAsyncTask.execute().get();
            //parse Json response and save into Object
            Gson gson = new Gson();
            Profile myProfile = gson.fromJson(json, Profile.class);
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
