package com.dudenakb.trivtix;

// Tanggal Pengerjaaan : 20 Juni 2020
// Deskripsi Pengerjaan :Membuat Hal Splash Screen, GetStarted dan Sig In
// NIM : 10117137
// Nama : Duden Heryana
// Kelas : IF-4

//Tanggal Pengerjaan : 26 Juni 2020
//Deskripsi Pengerjaan :Membuat Register1, Register2, Success_Register dan Home

//Tanggal Pengerjaan : 01 Juli 2020
//Deskripsi Pengerjaan :Membuat Ticket Destail, Ticket CheckOut dan Success Buy Ticket

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    LinearLayout btn_ticket_bridge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_ticket_bridge = findViewById(R.id.btn_ticket_bridge);
        btn_ticket_bridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuju_ticket_detail = new Intent(Home.this, Ticket_Detail.class);
                startActivity(menuju_ticket_detail);
            }
        });
    }
}
