package com.example.week3weekendapi;

import android.content.Context;
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
        holder.tvOne.setText(currentRepository.getName());
        holder.tvTwo.setText(currentRepository.getLanguage());
        holder.tvThree.setText(currentRepository.getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvOne)
        TextView tvOne;
        @BindView(R.id.tvTwo)
        TextView tvTwo;
        @BindView(R.id.tvThree)
        TextView tvThree;
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
