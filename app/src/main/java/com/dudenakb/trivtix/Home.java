package com.dudenakb.trivtix;

// NIM : 10117137
// Nama : Duden Heryana
// Kelas : IF-4

// Tanggal Pengerjaaan : 20 Juni 2020
// Deskripsi Pengerjaan :Membuat Hal Splash Screen, GetStarted dan Sign In

//Tanggal Pengerjaan : 26 Juni 2020
//Deskripsi Pengerjaan :Membuat Register1, Register2, Success_Register dan Home

//Tanggal Pengerjaan : 01 Juli 2020
//Deskripsi Pengerjaan :Membuat Ticket Destail, Ticket CheckOut dan Success Buy Ticket

//Tanggal Pengerjaan : 03 Juli 2020
//Deskripsi Pengerjaan : Membuat My Ticket Detail, Success By Ticket dan Edit Profile

//Tanggal Pengerjaan : 09 Juli 2020
//Deskripsi Pengerjaan : Firebase user register 1 dan 2, user login, integrasi home, integrasi tiket detail

//Tanggal Pengerjaan : 11 Juli 2020
//Deskripsi Pengerjaan : Firebase Tiket CekOut, memberikan validasi login & sisa saldo

//tanggal Pengerjaan : 13 Juli 2020
//Deskripsi Pengerjaan : Firebase My profile, My tiket detail

//tanggal Pengerjaan : 15 Juli 2020
//Deskripsi Pengerjaan : Firebase Edit Profile

//tanggal pengerjaan : 17 Juli 2020
//Deskripsi : Firebase Sign Out

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.florent37.shapeofview.shapes.CircleView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Home extends AppCompatActivity {

    LinearLayout btn_ticket_bridge, btn_ticket_waterfall, btn_ticket_lake;
    CircleView btn_to_profile;
    ImageView photo_home_user;
    TextView nama_lengkap, hobby, user_saldo;
    DatabaseReference reference;
    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String getsername_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getUsernameLocal();

        btn_ticket_bridge = findViewById(R.id.btn_ticket_bridge);
        btn_ticket_waterfall = findViewById(R.id.btn_ticket_waterfall);
        btn_ticket_lake = findViewById(R.id.btn_ticket_lake);

        btn_to_profile = findViewById(R.id.btn_to_profile);
        photo_home_user = findViewById(R.id.photo_home_user);

        nama_lengkap = findViewById(R.id.nama_lengkap);
        hobby = findViewById(R.id.hobby);
        user_saldo = findViewById(R.id.user_saldo);

        getUsernameLocal();

        reference = FirebaseDatabase.getInstance().getReference().child("Users").child(getsername_key_new);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nama_lengkap.setText(dataSnapshot.child("nama_lengkap").getValue().toString());
                hobby.setText(dataSnapshot.child("hobby").getValue().toString());
                user_saldo.setText("IDR " + dataSnapshot.child("user_saldo").getValue().toString());
                Picasso.with(Home.this).load(dataSnapshot.child("url_photo_profile").getValue().toString()).centerCrop().fit().into(photo_home_user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn_ticket_bridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuju_ticket_detail = new Intent(Home.this, Ticket_Detail.class);
                //meletakan data kepada intent
                menuju_ticket_detail.putExtra("jenis_tiket", "Bridge");
                startActivity(menuju_ticket_detail);
            }
        });

        btn_ticket_waterfall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuju_ticket_detail = new Intent(Home.this, Ticket_Detail.class);
                menuju_ticket_detail.putExtra("jenis_tiket", "Waterfall");
                startActivity(menuju_ticket_detail);
            }
        });

        btn_ticket_lake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuju_ticket_detail = new Intent(Home.this, Ticket_Detail.class);
                menuju_ticket_detail.putExtra("jenis_tiket", "Lake");
                startActivity(menuju_ticket_detail);
            }
        });

        btn_to_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuju_MyProfile = new Intent(Home.this, MyProfile.class);
                startActivity(menuju_MyProfile);
            }
        });
    }

    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        getsername_key_new = sharedPreferences.getString(username_key, "");
    }
}
