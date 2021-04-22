package com.example.zadanie1.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.zadanie1.model.GitRepo;
import com.example.zadanie1.repositories.GitRepoRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<GitRepo>> allegroGitRepos;
    private GitRepoRepository mRepo;

    public void init() {
        if(allegroGitRepos != null){
            return;
        }
        mRepo = GitRepoRepository.getInstance();
        allegroGitRepos = mRepo.getRepos();
    }

    public LiveData<List<GitRepo>> getAllegroGitRepos() {
        return allegroGitRepos;
    }
    public void makeApiCall(){mRepo.makeApiCall();}
}
