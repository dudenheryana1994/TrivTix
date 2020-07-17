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
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation app_splash, btt;
    ImageView app_logo;
    TextView app_sub_title;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String getUsername_key_new = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);

        //load element
        app_logo = findViewById(R.id.app_logo);
        app_sub_title = findViewById(R.id.app_sub_title);

        //run animation
        app_logo.startAnimation(app_splash);
        app_sub_title.startAnimation(btt);

        getUsernameLocal();

    }

    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        getUsername_key_new = sharedPreferences.getString(username_key, "");
        if (getUsername_key_new.isEmpty()){
            //setting timer untuk 2 detik
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //berpindah activity ke activity selanjutnya
                    Intent menuju_getstarted = new Intent(MainActivity. this, GetStarted.class);
                    startActivity(menuju_getstarted);
                    finish();
                }
            }, 2000); //2000 ms = 2 detik

        }
        else {
            //setting timer untuk 2 detik
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //berpindah activity ke activity selanjutnya
                    Intent menuju_home = new Intent(MainActivity. this, Home.class);
                    startActivity(menuju_home);
                    finish();
                }
            }, 2000); //2000 ms = 2 detik
        }
    }
}
