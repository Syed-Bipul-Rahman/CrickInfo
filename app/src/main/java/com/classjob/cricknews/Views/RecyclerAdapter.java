package com.classjob.cricknews.Views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.classjob.cricknews.Networks.Model.Matches;
import com.classjob.cricknews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Matches> matchItemList;

    public RecyclerAdapter(Context context, List<Matches> matchItemList) {
        this.context = context;
        this.matchItemList = matchItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.matches_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.matchNameTextView.setText(matchItemList.get(position).getMatchName());
        holder.matchDateTextView.setText(matchItemList.get(position).getDate());
        holder.winCountryTextView.setText(matchItemList.get(position).getWinCountryName());

        String wingImageUrl = matchItemList.get(position).getWinCountryFlag();
        Picasso.get().load(wingImageUrl).into(holder.winCountryFlagImageView);

        String lossImageUrl = matchItemList.get(position).getLossCountryFlag();
        Picasso.get().load(lossImageUrl).into(holder.lossCountryFlagImageView);

//others
        holder.lossCountryTextView.setText(matchItemList.get(position).getLossCountryName());

        holder.winCountryScoreTextView.setText(matchItemList.get(position).getWinCountryRunover());
        holder.lossCountryScoreTextView.setText(matchItemList.get(position).getLossCountryRunover());
        holder.matchresulttextview.setText(matchItemList.get(position).getMessege());
    }

    @Override
    public int getItemCount() {
        return matchItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView matchNameTextView, matchDateTextView, winCountryTextView, lossCountryTextView, winCountryScoreTextView, lossCountryScoreTextView, matchresulttextview;
        ImageView winCountryFlagImageView, lossCountryFlagImageView;
        // Define other views here

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            matchNameTextView = itemView.findViewById(R.id.matchname);
            matchDateTextView = itemView.findViewById(R.id.matchdate);
            winCountryFlagImageView = itemView.findViewById(R.id.wincountryflag);
            lossCountryFlagImageView = itemView.findViewById(R.id.losscountryflag);
            winCountryTextView = itemView.findViewById(R.id.wincountryname);
            lossCountryTextView = itemView.findViewById(R.id.losscountryname);
            winCountryScoreTextView = itemView.findViewById(R.id.winerRun);
            lossCountryScoreTextView = itemView.findViewById(R.id.lossRun);
            matchresulttextview = itemView.findViewById(R.id.matchresult);

        }
    }
}
