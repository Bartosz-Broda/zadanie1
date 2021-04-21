package com.example.zadanie1.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.zadanie1.model.GitRepo;

import java.util.ArrayList;
import java.util.List;

public class GitRepoRepository {
    private static GitRepoRepository instance;
    private ArrayList<GitRepo> dataset = new ArrayList<>();

    public static GitRepoRepository getInstance(){
        if(instance == null){
            instance = new GitRepoRepository();
        }
        return instance;
    }

    public MutableLiveData<List<GitRepo>> getRepos(){
        setRepos();

        MutableLiveData<List<GitRepo>> data = new MutableLiveData<>();
        data.setValue(dataset);
        return data;
    }

    private void setRepos(){
        dataset.add(
                new GitRepo("akubra", "Simple solution to keep a independent S3 storages in sync")
        );
        dataset.add(
                new GitRepo("akubra", "Simple solution to keep a independent S3 storages in sync")
        );
        dataset.add(
                new GitRepo("akubra", "Simple solution to keep a independent S3 storages in sync")
        );
        dataset.add(
                new GitRepo("akubra", "Simple solution to keep a independent S3 storages in sync")
        );

    }


}
