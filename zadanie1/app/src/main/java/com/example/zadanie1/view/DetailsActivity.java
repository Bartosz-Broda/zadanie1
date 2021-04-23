package com.example.zadanie1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.zadanie1.R;
import com.example.zadanie1.model.RepoDetailsModel;
import com.example.zadanie1.viewmodel.DetailsActivityViewModel;
import com.example.zadanie1.viewmodel.MainActivityViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "KURWA" ;
    private TextView repoName;
    private TextView repoDesc;
    private TextView repoInfo;
    private ImageView avatar;

    private DetailsActivityViewModel mViewModel;
    private List<RepoDetailsModel> mDetailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        int repoNumber = intent.getIntExtra("key", 0);

        mViewModel = ViewModelProviders.of(this).get(DetailsActivityViewModel.class);
        mViewModel.init();
        mViewModel.getRepoDetails().observe(this, repoDetailsModels -> {
            if (repoDetailsModels != null){
                mDetailsList = repoDetailsModels;
                repoName.setText(mDetailsList.get(repoNumber).getName());
                repoDesc.setText(mDetailsList.get(repoNumber).getDescription());
                repoInfo.setText(mDetailsList.get(repoNumber).getCreated_at());
            }

        });
        mViewModel.makeApiCall("repos");
        initUI();

    }

    private void initUI(){
        repoName = findViewById(R.id.repo_name);
        repoDesc = findViewById(R.id.repo_desc);
        repoInfo = findViewById(R.id.repo_info1);
        avatar = findViewById(R.id.avatar_image);
    }
}