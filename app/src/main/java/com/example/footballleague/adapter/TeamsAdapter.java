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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballleague.R;
import com.example.footballleague.model.detailsteam.DetailsTeams;
import com.example.footballleague.model.teams.TeamsItem;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsHolder> {

    private List<TeamsItem> itemList;
    private List<DetailsTeams> detailsTeams;
    Context context;
OnTeamslistener onTeamslistener;

    public TeamsAdapter(List<TeamsItem> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    public TeamsAdapter(List<TeamsItem> itemList, List<DetailsTeams> detailsTeams, Context context) {
        this.itemList = itemList;
        this.detailsTeams = detailsTeams;
        this.context = context;
    }

    public TeamsAdapter(List<TeamsItem> itemList, List<DetailsTeams> detailsTeams, Context context, OnTeamslistener onTeamslistener) {
        this.itemList = itemList;
        this.detailsTeams = detailsTeams;
        this.context = context;
        this.onTeamslistener = onTeamslistener;
    }

    @NonNull
    @Override
    public TeamsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_item, parent, false);
        return new TeamsHolder(view,onTeamslistener);
    }


    @Override
    public void onBindViewHolder(@NonNull TeamsHolder holder, int position) {
        SpannableString spannableString=new SpannableString(itemList.get(position).getWebsite());
        holder.name_team.setText(itemList.get(position).getName());
        holder.color.setText(itemList.get(position).getClubColors());
      //  holder.website.setText(itemList.get(position).getWebsite());
        holder.venue.setText(itemList.get(position).getVenue());
       holder.players.setText(itemList.get(position).getDetailsTeams().getSquad().toString().replace("[","").replace("]",""));
        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(holder.website.getText().toString()));
                context.startActivity(i);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(true);
            }
        };
        spannableString.setSpan(clickableSpan,0,itemList.get(position).getWebsite().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.website.setText(spannableString);
        holder.website.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void addItems(List<TeamsItem>items ) {
        this.itemList.addAll(items);
        notifyDataSetChanged();
    }
    public interface OnTeamslistener {
        void onTeamsClick(int postion,TextView teamsHolder);
    }

    class TeamsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name_team, website, color, venue, players;
        OnTeamslistener onTeamslistener;

        public TeamsHolder(@NonNull View itemView,OnTeamslistener onTeamslistener) {
            super(itemView);
            name_team = itemView.findViewById(R.id.name_team);
            website = itemView.findViewById(R.id.website_team);
            color = itemView.findViewById(R.id.color_team);
            venue = itemView.findViewById(R.id.venue_team);
            players=itemView.findViewById(R.id.player);
            this.onTeamslistener = onTeamslistener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
onTeamslistener.onTeamsClick(getAdapterPosition(),website);
        }
    }
}

