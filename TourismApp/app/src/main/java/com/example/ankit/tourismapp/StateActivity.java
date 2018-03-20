package com.example.ankit.tourismapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.views.BannerSlider;

public class StateActivity extends AppCompatActivity {
    public static List<StateAdd> stateAddList;//List to hold products
    private DatabaseReference mDataRef;
    RecyclerView recyclerViewStates;
    StateAdapter adapter;//adapter to link products
    Button logoutBtn;
    //for search

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
        stateAddList = new ArrayList<>();
        //logoutBtn = findViewById(R.id.logout);
        recyclerViewStates = findViewById(R.id.recyclerViewState);
        recyclerViewStates.setHasFixedSize(true);
        recyclerViewStates.setLayoutManager(new LinearLayoutManager(StateActivity.this));
//        logoutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                logout();
//                finish();
//            }
//        });
        List<Banner> banners=new ArrayList<>();
        BannerSlider bannerSlider = findViewById(R.id.banner);
        //add banner using image url
        //banners.add(new RemoteBanner("Put banner image url here ..."));
        //add banner using resource drawable
        banners.add(new DrawableBanner(R.drawable.one));
        banners.add(new DrawableBanner(R.drawable.two));
        banners.add(new DrawableBanner(R.drawable.three));
        banners.add(new DrawableBanner(R.drawable.four));
        bannerSlider.setBanners(banners);



        //creating recyclerview adapter
        mDataRef = FirebaseDatabase.getInstance().getReference().child("State");
        mDataRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String sName = (String)dataSnapshot1.child("sName").getValue();
                    String id =(String)dataSnapshot1.child("sId").getValue();
                    String sTotalCity =(String)dataSnapshot1.child("sTotalCity").getValue();
                    String sCapital =(String)dataSnapshot1.child("sCapital").getValue();
                    String img = (String)dataSnapshot1.child("sImgurl").getValue();
                    stateAddList.add(new StateAdd(sName,id,sTotalCity,sCapital,img));
                }
                adapter = new StateAdapter(StateActivity.this,stateAddList);
                recyclerViewStates.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(StateActivity.this, "Error:"+databaseError, Toast.LENGTH_SHORT).show();
            }
        });

        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(false);
        mLayoutManager.setStackFromEnd(false);
        recyclerViewStates.setLayoutManager(mLayoutManager);
    }
    public void logout(){
        Toast.makeText(this,"Logout Successfully",Toast.LENGTH_SHORT).show();
        FirebaseAuth.getInstance().signOut();
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
        finish();
    }
}
