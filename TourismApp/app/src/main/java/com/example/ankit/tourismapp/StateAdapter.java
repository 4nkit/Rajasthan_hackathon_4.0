package com.example.ankit.tourismapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Ankit on 15-03-2018.
 */

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateViewHolder>{

    public Context context;
    public String abc;
    public static String sName;
    public List<StateAdd> stateAddList;
    public CardView cardView;
    public StateAdapter(Context context,List<StateAdd> stateAddList){
        this.context = context;
        this.stateAddList = stateAddList;
    }
    @Override
    public StateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_state,parent,false);
        return new StateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateViewHolder holder, final int position) {
        final StateAdd sAdd = stateAddList.get(position);
        holder.stateName.setText(sAdd.getsName());
        //holder.stateId.setText(sAdd.getsId());
        holder.stateTotalCity.setText("Total cities: "+sAdd.getsTotalCity());
        holder.stateCapital.setText("Capital: "+sAdd.getsCapital());
        Glide.with(context.getApplicationContext()).load(String.valueOf(sAdd.getsImgurl())).into(holder.img);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StateAdd s = stateAddList.get(position);
                abc = s.getsName();
                Intent i = new Intent(context,CityActivity.class);
                i.putExtra("stateName",abc);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return stateAddList.size();
    }

    class StateViewHolder extends RecyclerView.ViewHolder {

        TextView stateName,stateTotalCity,stateCapital;
        CardView cardView;
        ImageView img;

        public StateViewHolder(final View itemView) {
            super(itemView);
            stateName = itemView.findViewById(R.id.stateName);
            stateTotalCity = itemView.findViewById(R.id.stateTotalCity);
            stateCapital = itemView.findViewById(R.id.stateCapital);
            img = itemView.findViewById(R.id.imageState);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

}
