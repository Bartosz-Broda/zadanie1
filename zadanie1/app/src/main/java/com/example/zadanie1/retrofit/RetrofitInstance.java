package com.example.zadanie1.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String BASE_URL1 = "https://api.github.com/users/allegro/";//base url for a list of repositories
    public static String BASE_URL2 = "https://api.github.com/repos/allegro/";//base url for details about chosen repository

    private static Retrofit retrofit;

    public static Retrofit getRetroClient(int urlType) {

            if (urlType == 1) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL1)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            //made for fetching details about chosen repository
            else if(urlType == 2){
                retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();}

        return retrofit;
    }

}
