package com.example.footballleague.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballleague.R;
import com.example.footballleague.model.detailsteam.DetailsTeams;
import com.example.footballleague.model.teams.TeamsItem;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "TeamsAdapter";

    private List<TeamsItem> itemList;
    private List<DetailsTeams> detailsTeams;
    Context context;
    OnTeamslistener onTeamslistener;


    public TeamsAdapter(List<TeamsItem> itemList, List<DetailsTeams> detailsTeams, Context context, OnTeamslistener onTeamslistener) {
        this.itemList = itemList;
        this.detailsTeams = detailsTeams;
        this.context = context;
        this.onTeamslistener = onTeamslistener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_item, parent, false);
            return new ProgressBarHolder(view);
        } else {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_item, parent, false);
            return new TeamsHolder(view, onTeamslistener);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == itemList.size() - 1 && itemList.size() < 20) {
            Log.i(TAG, "getItemViewType position: " + position);

            return 1;
        }
        return 2;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == 2) {
            SpannableString spannableString = new SpannableString(itemList.get(position).getWebsite());
            ((TeamsHolder) holder).name_team.setText(itemList.get(position).getName());
            ((TeamsHolder) holder).color.setText(itemList.get(position).getClubColors());
            //  holder.website.setText(itemList.get(position).getWebsite());
            ((TeamsHolder) holder).venue.setText(itemList.get(position).getVenue());
            ((TeamsHolder) holder).players.setText(detailsTeams.get(position).getSquad().toString().replace("[", "").replace("]", ""));
            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(@NonNull View view) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(((TeamsHolder) holder).website.getText().toString()));
                    context.startActivity(i);
                }

                @Override
                public void updateDrawState(@NonNull TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setColor(Color.BLUE);
                    ds.setUnderlineText(true);
                }
            };
            spannableString.setSpan(clickableSpan, 0, itemList.get(position).getWebsite().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ((TeamsHolder) holder).website.setText(spannableString);
            ((TeamsHolder) holder).website.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCount: " + itemList.size());
        Log.i(TAG, "getItemCount: " + detailsTeams.size());

        return itemList.size();
    }

    public void addItems(List<TeamsItem> items, List<DetailsTeams> detailsTeams) {
        this.itemList.addAll(items);
        this.detailsTeams.addAll(detailsTeams);
        notifyDataSetChanged();
    }

    public interface OnTeamslistener {
        void onTeamsClick(int postion, TextView teamsHolder);
    }

    class TeamsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name_team, website, color, venue, players;
        OnTeamslistener onTeamslistener;

        public TeamsHolder(@NonNull View itemView, OnTeamslistener onTeamslistener) {
            super(itemView);
            name_team = itemView.findViewById(R.id.name_team);
            website = itemView.findViewById(R.id.website_team);
            color = itemView.findViewById(R.id.color_team);
            venue = itemView.findViewById(R.id.venue_team);
            players = itemView.findViewById(R.id.player);
            this.onTeamslistener = onTeamslistener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onTeamslistener.onTeamsClick(getAdapterPosition(), website);
        }
    }

    class ProgressBarHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;

        public ProgressBarHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.prograssbar);
        }
    }
}

