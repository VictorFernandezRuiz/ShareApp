package com.example.shareapp;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CallApi {

    OkHttpClient client = new OkHttpClient();

    public CallApi(String user, String password) {
    }


    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String callApi(String user, String password) throws IOException {

        CallApi callApi = new CallApi(user,password);

        String response = callApi.run("http://10.0.2.2:8080/apiz-0.0.1-SNAPSHOT/ExecuteLogin/" + user + "/" + password);
        System.out.println(response);
        return response;
    }

}
