package com.example.ankit.tourismapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText city,place,desc;
    Button addBtn,data,emergency;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        city = findViewById(R.id.editTextCityName);
        place = findViewById(R.id.editTextPlaceName);
        desc = findViewById(R.id.editTextPlaceDesc);
        addBtn = findViewById(R.id.addState);
        emergency = findViewById(R.id.emergency);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,EmergencyActivity.class));
            }
        });
        data = findViewById(R.id.data);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,StateActivity.class));
            }
        });
    }

    private void add() {
        String cityName = city.getText().toString();
        String placeName = place.getText().toString();
        String pId = databaseReference.push().getKey();
        String description = desc.getText().toString();
        Add a = new Add(placeName,pId,description);
        databaseReference.child("State").child("Rajasthan").child("City").child(cityName).child("Place").child(placeName).setValue(a);
        Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
    }

}
