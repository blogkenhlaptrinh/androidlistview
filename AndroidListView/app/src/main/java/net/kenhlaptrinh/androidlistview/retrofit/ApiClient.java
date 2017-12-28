package net.kenhlaptrinh.androidlistview.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TUNG DUONG on 28/05/2017.
 */

public class ApiClient {

    private API api;
    private String URL = "https://kenhlaptrinh.net/dulieu/laptrinhandroid/";

    public API getClient() {
        if (api == null) {
            Gson gson = new GsonBuilder().setLenient().create();
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();
            api = new Retrofit.Builder()
                    .baseUrl(URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build().create(API.class);
        }
        return api;
    }

}
