package com.example.zadanie1.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zadanie1.R;
import com.example.zadanie1.model.GitRepo;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private static final String TAG = "RecyclerAdapter";

    private List<GitRepo> mGitRepos;
    private Context mContext;

    public RecyclerAdapter(List<GitRepo> mGitRepos, Context mContext) {
        this.mGitRepos = mGitRepos;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        //Sets name of repository
        ((ViewHolder)holder).name.setText(mGitRepos.get(position).getName());

        //Sets description of the repository
        ((ViewHolder)holder).shortDescription.setText(mGitRepos.get(position).getShortDescription());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on something");

                Toast.makeText(mContext, mGitRepos.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mGitRepos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView shortDescription;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.repository_name);
            shortDescription = itemView.findViewById(R.id.short_desc);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
