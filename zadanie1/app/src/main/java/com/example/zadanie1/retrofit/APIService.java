package com.example.zadanie1.retrofit;

import com.example.zadanie1.model.GitRepo;
import com.example.zadanie1.model.RepoDetailsModel;
import com.example.zadanie1.repositories.RepoDetailsRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface APIService {

    @GET("{repo_name}")
    Call<List<GitRepo>> getGitRepos(@Path(value = "repo_name", encoded = true) String repoName);

    @GET("{repo_name}")
    Call<List<RepoDetailsModel>> getRepoDetails(@Path(value = "repo_name", encoded = true) String repoName);

}
