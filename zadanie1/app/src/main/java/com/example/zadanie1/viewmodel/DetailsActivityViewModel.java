package com.example.zadanie1.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.zadanie1.model.GitRepo;
import com.example.zadanie1.model.RepoDetailsModel;
import com.example.zadanie1.repositories.GitRepoRepository;
import com.example.zadanie1.repositories.RepoDetailsRepository;

import java.util.List;

public class DetailsActivityViewModel extends ViewModel {
    private MutableLiveData<List<RepoDetailsModel>> detailsAboutRepo;
    private RepoDetailsRepository mRepo;

    public void init() {
        if(detailsAboutRepo != null){
            return;
        }
        mRepo = RepoDetailsRepository.getInstance();
        detailsAboutRepo = mRepo.getRepos();
    }

    public LiveData<List<RepoDetailsModel>> getRepoDetails() {
        return detailsAboutRepo;
    }
    public void makeApiCall(String repoName){mRepo.makeApiCall(repoName);}
}
