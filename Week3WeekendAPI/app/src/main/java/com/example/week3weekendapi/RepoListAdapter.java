package com.example.week3weekendapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.week3weekendapi.model.repos.Repository;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoListAdapter extends Adapter<RepoListAdapter.ViewHolder> {
    ArrayList<Repository> repoList;

    public RepoListAdapter(ArrayList<Repository> repoList) {
        this.repoList = repoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_list_item,parent,false);
        return new ViewHolder(inflatedItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repository currentRepository = repoList.get(position);
        holder.tvName.setText(currentRepository.getName());
        holder.tvLanguage.setText(currentRepository.getLanguage());
        holder.tvLastUpdate.setText(currentRepository.getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvLanguage)
        TextView tvLanguage;
        @BindView(R.id.tvLastUpdate)
        TextView tvLastUpdate;
        Repository itemRepository;

        public void setItemRepository(Repository itemRepository) {
            this.itemRepository = itemRepository;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
