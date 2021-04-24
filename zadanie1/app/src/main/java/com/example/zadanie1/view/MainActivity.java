package com.example.zadanie1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import com.example.zadanie1.R;
import com.example.zadanie1.adapters.RecyclerAdapter;
import com.example.zadanie1.model.GitRepo;
import com.example.zadanie1.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private MainActivityViewModel mMainActivityViewModel;
    private List<GitRepo> gitRepoList;

    private Animation fadeOutAnim;
    private ProgressBar loadProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: application started.");

        fadeOutAnim = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        loadProgress = findViewById(R.id.load_proressbar);
        loadProgress.setVisibility(View.VISIBLE);

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getAllegroGitRepos().observe(this, new Observer<List<GitRepo>>() {
            @Override
            public void onChanged(List<GitRepo> gitRepos) {
                loadProgress.startAnimation(fadeOutAnim);
                gitRepoList = gitRepos;
                Log.d(TAG, "onChanged: " + gitRepoList);
                adapter.setmGitRepos(gitRepoList);
            }
        });

        mMainActivityViewModel.makeApiCall();
        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: initiated");
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerAdapter(gitRepoList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }



}