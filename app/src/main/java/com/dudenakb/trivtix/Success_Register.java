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

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Success_Register extends AppCompatActivity {

    Button btn_explore;
    Animation app_splash, btt, ttb;
    ImageView icon_success;
    TextView app_title, app_sub_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success__register);

        icon_success = findViewById(R.id.ic_success);
        app_title = findViewById(R.id.app_title);
        app_sub_title = findViewById(R.id.app_sub_title);
        btn_explore = findViewById(R.id.btn_explore);

        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);

        //run animation
        btn_explore.startAnimation(btt);
        icon_success.startAnimation(app_splash);
        app_title.startAnimation(ttb);
        app_sub_title.startAnimation(ttb);

        btn_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuju_home = new Intent(Success_Register.this, Home.class);
                startActivity(menuju_home);
            }
        });
    }
}
