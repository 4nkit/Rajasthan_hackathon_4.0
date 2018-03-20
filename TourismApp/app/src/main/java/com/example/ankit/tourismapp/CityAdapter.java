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

import static com.example.ankit.tourismapp.StateActivity.stateAddList;

/**
 * Created by Ankit on 15-03-2018.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder>{

    public Context context;
    public List<CityAdd> cityAddList;
    public CardView cardView;

    public CityAdapter(Context context, List<CityAdd> cityAddList){
        this.context = context;
        this.cityAddList = cityAddList;
    }
    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_city,parent,false);
        cardView = view.findViewById(R.id.cardView);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, final int position) {
        final CityAdd cAdd = cityAddList.get(position);
        holder.cityName.setText(cAdd.getcName());
        //holder.cityId.setText(cAdd.getcId());
        holder.cityPlace.setText(cAdd.getcPlace());
        Glide.with(context.getApplicationContext()).load(String.valueOf(cAdd.getcImgurl())).into(holder.img);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CityAdd c = cityAddList.get(position);
                StateAdd s = stateAddList.get(position);
                String city = c.getcName();
                //String state  = s.getsName();
                Intent i = new Intent(context,PlaceActivity.class);
                i.putExtra("cityName",city);
                //i.putExtra("stateName",state);
                //Toast.makeText(context, "state: "+state+"city: "+city, Toast.LENGTH_SHORT).show();
                context.startActivity(i);
               // Toast.makeText(context, "End of city activity", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cityAddList.size();
    }

    class CityViewHolder extends RecyclerView.ViewHolder {

        TextView cityName,cityId,cityPlace;
        ImageView img;
        CardView cardView;

        public CityViewHolder(final View itemView) {
            super(itemView);
  //          final StateAdd stateAdd = stateAddList.get(getLayoutPosition());
            cityName = itemView.findViewById(R.id.cityName);
            //cityId = itemView.findViewById(R.id.cityId);
            cityPlace = itemView.findViewById(R.id.cityPlace);
            img = itemView.findViewById(R.id.imageCity);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

}
