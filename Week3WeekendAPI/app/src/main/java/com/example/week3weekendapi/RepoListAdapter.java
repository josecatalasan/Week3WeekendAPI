package com.example.week3weekendapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.example.week3weekendapi.model.repos.Repository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
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
        holder.tvLastUpdate.setText(String.format("Updated %s ago", getTimeSince(currentRepository.getUpdatedAt())));
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    private String getTimeSince(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

        long diff = 0;
        String period = " days";

        try {
            Date updated = sdf.parse(date);
            Date today = Calendar.getInstance().getTime();

            long diffInMillies = Math.abs(today.getTime() - updated.getTime());
            diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            if(diff == 1)
                period = " day";

            if(diff < 1){
                diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                if(diff == 1)
                    period = " hour";
                else
                    period = " hours";
            }if(diff < 1){
                diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
                if(diff == 1)
                    period = " minute";
                else
                    period = " minutes";
            }
            if(diff < 1){
                diff = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                if(diff == 1)
                    period = " second";
                else
                    period = " seconds";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return diff + period;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvLanguage)
        TextView tvLanguage;
        @BindView(R.id.tvLastUpdate)
        TextView tvLastUpdate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
