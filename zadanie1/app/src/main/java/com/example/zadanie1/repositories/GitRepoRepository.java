package com.example.zadanie1.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.zadanie1.model.GitRepo;
import com.example.zadanie1.retrofit.APIService;
import com.example.zadanie1.retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitRepoRepository {
    private static GitRepoRepository instance;
    MutableLiveData<List<GitRepo>> data = new MutableLiveData<>();

    public static GitRepoRepository getInstance(){
        if(instance == null){
            instance = new GitRepoRepository();
        }
        return instance;
    }

    public MutableLiveData<List<GitRepo>> getRepos(){
        return data;
    }

    public void makeApiCall() {
        APIService apiService = RetrofitInstance.getRetroClient().create(APIService.class);
        Call<List<GitRepo>> call = apiService.getGitRepos("repos");
        call.enqueue(new Callback<List<GitRepo>>() {
            @Override
            public void onResponse(Call<List<GitRepo>> call, Response<List<GitRepo>> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<GitRepo>> call, Throwable t) {
                data.postValue(null);
            }
        });
    }



}
