package com.example.ankit.tourismapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PlaceActivity extends AppCompatActivity {
    private List<Place> placeList;//List to hold products
    private DatabaseReference mDataRef;
    RecyclerView recyclerViewPlace;
    PlaceAdapter adapter;//adapter to link products

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        Bundle bundle = getIntent().getExtras();
        //String sname = bundle.getString("stateName");
        String cname = bundle.getString("cityName");
        placeList = new ArrayList<>();
        recyclerViewPlace = findViewById(R.id.recyclerViewPlace);
        recyclerViewPlace.setHasFixedSize(true);
        recyclerViewPlace.setLayoutManager(new LinearLayoutManager(PlaceActivity.this,LinearLayoutManager.HORIZONTAL,true));
        //creating recyclerview adapter
        //Toast.makeText(this, "State Name: "+sname, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "City Name: "+cname, Toast.LENGTH_SHORT).show();
        mDataRef = FirebaseDatabase.getInstance().getReference().child("State").child("Rajasthan").child("City").child(cname).child("Place");
        mDataRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String pName = (String)dataSnapshot1.child("pName").getValue();
                    String id =(String)dataSnapshot1.child("pId").getValue();
                    String pDesc =(String)dataSnapshot1.child("pDesc").getValue();
                    String pImg = (String)dataSnapshot1.child("pImgurl").getValue();
                    placeList.add(new Place(pName,id,pDesc,pImg));
                }
                adapter = new PlaceAdapter(PlaceActivity.this,placeList);
                recyclerViewPlace.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(PlaceActivity.this, "Error:"+databaseError, Toast.LENGTH_SHORT).show();
            }
        });

        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(false);
        mLayoutManager.setStackFromEnd(false);
        recyclerViewPlace.setLayoutManager(mLayoutManager);
    }
}
