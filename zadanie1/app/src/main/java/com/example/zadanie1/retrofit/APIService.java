package com.example.zadanie1.retrofit;

import com.example.zadanie1.model.GitRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("repos")
    Call<List<GitRepo>> getGitRepos();

}
