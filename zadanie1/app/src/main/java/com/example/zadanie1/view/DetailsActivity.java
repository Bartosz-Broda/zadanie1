package com.example.zadanie1.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.zadanie1.R;
import com.example.zadanie1.model.RepoDetailsModel;
import com.example.zadanie1.viewmodel.DetailsActivityViewModel;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "KURWA" ;
    private TextView repoName;
    private TextView repoDesc;
    private TextView repoLang;
    private TextView repoCreatedAt;
    private TextView repoPushedAt;
    private TextView repoWatchers;
    private TextView repoSize;
    private TextView repoForks;
    private ImageView avatar;
    private TextView defBranch;

    private TextView text1;
    private TextView text2;

    private DetailsActivityViewModel mViewModel;
    private List<RepoDetailsModel> mDetailsList;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        int repoNumber = intent.getIntExtra("key", 0);

        //Date and time formatter for proper CEST time
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT )
                .withLocale(Locale.UK)
                .withZone( ZoneId.systemDefault() );

        mViewModel = ViewModelProviders.of(this).get(DetailsActivityViewModel.class);
        mViewModel.init();
        mViewModel.getRepoDetails().observe(this, repoDetailsModels -> {
            if (repoDetailsModels != null){
                mDetailsList = repoDetailsModels;

                //Loading Allegro Avatar
                Glide.with(this)
                        .load(mDetailsList.get(repoNumber).getOwner().getAvatar_url())
                        .apply(RequestOptions.circleCropTransform())
                        .into(avatar);

                //Loading Repository info
                repoName.setText(mDetailsList.get(repoNumber).getName());
                if(mDetailsList.get(repoNumber).getDescription() == null){repoDesc.setVisibility(View.GONE); text1.setVisibility(View.GONE);}
                else{repoDesc.setText(mDetailsList.get(repoNumber).getDescription());}
                if(mDetailsList.get(repoNumber).getLanguage() == null){repoLang.setVisibility(View.GONE); text2.setVisibility(View.GONE);}
                else{repoLang.setText(mDetailsList.get(repoNumber).getLanguage());}

                Instant instant = Instant.parse(mDetailsList.get(repoNumber).getCreated_at());
                repoCreatedAt.setText(formatter.format(instant));
                repoCreatedAt.append(" CEST");

                Instant instant1 = Instant.parse(mDetailsList.get(repoNumber).getPushed_at());
                repoPushedAt.setText(formatter.format(instant1));
                repoPushedAt.append(" CEST");
                //Log.d(TAG, "XDDonCreate: "+ formatter.format(instant));

                repoWatchers.setText(String.valueOf(mDetailsList.get(repoNumber).getWatchers()));
                repoSize.setText(String.valueOf(mDetailsList.get(repoNumber).getSize()));
                repoForks.setText(String.valueOf(mDetailsList.get(repoNumber).getForks()));
                defBranch.setText(mDetailsList.get(repoNumber).getDefault_branch());

            }

        });
        mViewModel.makeApiCall("repos");
        initUI();

    }

    private void initUI(){
        repoName = findViewById(R.id.repo_name);
        repoDesc = findViewById(R.id.repo_desc);
        repoLang = findViewById(R.id.language);
        repoCreatedAt = findViewById(R.id.created_at);
        repoPushedAt = findViewById(R.id.updated_at);
        repoWatchers = findViewById(R.id.watchers);
        repoSize = findViewById(R.id.size);
        avatar = findViewById(R.id.avatar_image);
        repoForks = findViewById(R.id.forks);
        text1 = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView2);
        defBranch = findViewById(R.id.default_branch);
    }
}