package com.example.week3weekendapi.model.datasource.remote;

import com.example.week3weekendapi.BuildConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectionHelper {
    public static final String COMPLETE_URL = "https://randomuser.me/api/?result=5";
    public static final String MY_USER_PROFILE = "https://api.github.com/users/josecatalasan";
    public static final String MY_USER_PROFILE2 = "api.github.com/users/josecatalasan";
    public static final String MY_REPO_LIST = "https://api.github.com/users/josecatalasan/repos";
    public static final String PROF_URL = "https://" + BuildConfig.ACCESS_TOKEN + ":x-oauth-basic@" + MY_USER_PROFILE2;
    public static final String REPO_URL = "https://" + BuildConfig.ACCESS_TOKEN + ":x-oauth-basic@" + MY_REPO_LIST;

    private static HttpURLConnection httpURLConnection;
    private static URL url;

    public static String doApiCall() {
        String jsonResponse = "";
        try {
            url = new URL(MY_USER_PROFILE);
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
}
