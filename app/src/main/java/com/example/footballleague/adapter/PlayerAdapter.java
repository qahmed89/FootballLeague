package com.example.footballleague.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballleague.R;
import com.example.footballleague.model.detailsteam.DetailsTeams;
import com.example.footballleague.model.detailsteam.SquadItem;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerHolder> {
    List<SquadItem> detailsTeams;
    Context context;

    public PlayerAdapter(List<SquadItem> detailsTeams, Context context) {
        this.detailsTeams = detailsTeams;
        this.context = context;
    }

    @NonNull
    @Override
    public PlayerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item, parent, false);
        return new PlayerHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull PlayerHolder holder, int position) {
holder.player_name.setText(detailsTeams.get(position).getName());
        holder.postion.setText(detailsTeams.get(position).getPosition());
        holder.dateOfBirth.setText(detailsTeams.get(position).getDateOfBirth());
        holder.countryOfBirth.setText(detailsTeams.get(position).getCountryOfBirth());
        holder.role.setText(detailsTeams.get(position).getRole());

    }

    @Override
    public int getItemCount() {
        return detailsTeams.size();
    }

    public class PlayerHolder extends RecyclerView.ViewHolder {
        TextView player_name , postion, dateOfBirth,countryOfBirth,role;
        public PlayerHolder(@NonNull View itemView) {
            super(itemView);
            player_name=itemView.findViewById(R.id.name_player);
            postion=itemView.findViewById(R.id.postion_player);
            dateOfBirth=itemView.findViewById(R.id.dateofbirth_player);
            countryOfBirth=itemView.findViewById(R.id.countryofbirth_player);
            role=itemView.findViewById(R.id.role_player);
        }
    }
}
