package com.example.ankit.tourismapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class CityActivity extends AppCompatActivity {
    private List<CityAdd> cityAddList;//List to hold products
    private DatabaseReference mDataRef;
    RecyclerView recyclerViewCitys;
    CityAdapter adapter;//adapter to link products

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        Bundle bundle = getIntent().getExtras();
        String sname = bundle.getString("stateName");
        cityAddList = new ArrayList<>();
        recyclerViewCitys = findViewById(R.id.recyclerViewCity);
        recyclerViewCitys.setHasFixedSize(true);
        recyclerViewCitys.setLayoutManager(new LinearLayoutManager(CityActivity.this));
        //creating recyclerview adapter
        mDataRef = FirebaseDatabase.getInstance().getReference().child("State").child(sname).child("City");
        mDataRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String cName = (String)dataSnapshot1.child("cName").getValue();
                    String id =(String)dataSnapshot1.child("cId").getValue();
                    String cPlace =(String)dataSnapshot1.child("cPlace").getValue();
                    String cImg = (String)dataSnapshot1.child("cImgurl").getValue();
                    cityAddList.add(new CityAdd(cName,id,cPlace,cImg));
                }
                adapter = new CityAdapter(CityActivity.this,cityAddList);
                recyclerViewCitys.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(CityActivity.this, "Error:"+databaseError, Toast.LENGTH_SHORT).show();
            }
        });

        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(false);
        mLayoutManager.setStackFromEnd(false);
        recyclerViewCitys.setLayoutManager(mLayoutManager);
    }
}
