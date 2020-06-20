package com.dudenakb.trivtix;

// Tanggal Pengerjaaan : 20 Juni 2020
// Deskripsi Pengerjaan :Membuat Hal Splash Screen, GetStarted dan Sig In
// NIM : 10117137
// Nama : Duden Heryana
// Kelas : IF-4

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting timer untuk 1 detik
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //berpindah activity ke activity selanjutnya
                Intent menuju_getstarted = new Intent(MainActivity. this, GetStarted.class);
                startActivity(menuju_getstarted);
                finish();
            }
        }, 1000); //1000 ms = 1 detik
    }
}
