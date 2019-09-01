package com.example.week3weekendapi.model.datasource.remote;

import com.example.week3weekendapi.BuildConfig;
import com.example.week3weekendapi.model.repos.Repository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpUrlConnectionHelper {
    public static final String MY_USER_PROFILE = "https://api.github.com/users/josecatalasan";
    public static final String MY_USER_PROFILE2 = "api.github.com/users/josecatalasan";
    public static final String MY_REPO_LIST = "https://api.github.com/users/josecatalasan/repos";
    public static final String MY_REPO_LIST2 = "api.github.com/users/josecatalasan/repos";
    public static final String PROF_URL = "https://" + BuildConfig.ACCESS_TOKEN + ":x-oauth-basic@" + MY_USER_PROFILE2;
    public static final String REPO_URL = "https://" + BuildConfig.ACCESS_TOKEN + ":x-oauth-basic@" + MY_REPO_LIST2;

    private static HttpURLConnection httpURLConnection;
    private static URL url;

    public static String doProfileApiCall(String apiCall) {
        String jsonResponse = "";
        try {
            url = new URL(apiCall);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();

            int currentRead = inputStream.read();
            while(currentRead != -1){
                char currentChar = (char)currentRead;
                jsonResponse += currentChar;
                currentRead = inputStream.read();
            }
            return jsonResponse;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Repository> doRepoApiCall(String apiCall) {
        String jsonResponse = "";
        try {
            ArrayList<Repository> returnList = new ArrayList<>();
            url = new URL(apiCall);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();

            //Parse inputStream
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            reader.beginArray();
            while(reader.hasNext()){
                Repository repository = gson.fromJson(reader, Repository.class);
                returnList.add(repository);
            }
            return returnList;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
