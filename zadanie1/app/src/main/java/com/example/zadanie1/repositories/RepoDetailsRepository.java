package com.example.zadanie1.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.zadanie1.model.GitRepo;
import com.example.zadanie1.model.RepoDetailsModel;
import com.example.zadanie1.retrofit.APIService;
import com.example.zadanie1.retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoDetailsRepository {
    private static RepoDetailsRepository instance;
    MutableLiveData<List<RepoDetailsModel>> data = new MutableLiveData<>();

    public static RepoDetailsRepository getInstance(){
        if(instance == null){
            instance = new RepoDetailsRepository();
        }
        return instance;
    }

    public MutableLiveData<List<RepoDetailsModel>> getRepos(){
        return data;
    }

    public void makeApiCall(String repoName) {
        APIService apiService = RetrofitInstance.getRetroClient(1).create(APIService.class);
        Call<List<RepoDetailsModel>> call = apiService.getRepoDetails(repoName);
        call.enqueue(new Callback<List<RepoDetailsModel>>() {
            @Override
            public void onResponse(Call<List<RepoDetailsModel>> call, Response<List<RepoDetailsModel>> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<RepoDetailsModel>> call, Throwable t) {
                data.postValue(null);
            }
        });
    }
}
