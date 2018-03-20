package com.example.ankit.tourismapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Ankit on 15-03-2018.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>{

    public Context context;
    public List<Place> placeList;
    public CardView cardView;

    public PlaceAdapter(Context context, List<Place> placeList){
        this.context = context;
        this.placeList = placeList;
    }
    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_place,parent,false);
        cardView = view.findViewById(R.id.cardView);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        final Place p = placeList.get(position);
        holder.placeName.setText(p.getpName());
        holder.placeDesc.setText(p.getpDesc());
        Glide.with(context.getApplicationContext()).load(String.valueOf(p.getpImgurl())).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder {

        TextView placeName,placeId,placeDesc;
        ImageView img;
        CardView cardView;

        public PlaceViewHolder(final View itemView) {
            super(itemView);
            placeName = itemView.findViewById(R.id.placeName);
            placeDesc = itemView.findViewById(R.id.placeDesc);
            img = itemView.findViewById(R.id.placeImage);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

}
