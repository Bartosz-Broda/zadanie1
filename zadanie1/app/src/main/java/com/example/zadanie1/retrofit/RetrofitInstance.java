package com.example.zadanie1.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String BASE_URL1 = "https://api.github.com/users/allegro/";//base url for list of repositories

    private static Retrofit retrofit;

    public static Retrofit getRetroClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
