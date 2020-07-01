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
import android.widget.Button;
import android.widget.TextView;

public class Sign_In extends AppCompatActivity {

    TextView btn_new_account;
    Button btn_sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__in);

        btn_new_account = findViewById(R.id.btn_new_account);
        btn_sign_in = findViewById(R.id.btn_sign_in);

        btn_new_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menujuregister1 = new Intent(Sign_In.this, Register1.class);
                startActivity(menujuregister1);
            }
        });
        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuju_home = new Intent(Sign_In.this, Home.class);
                startActivity(menuju_home);
            }
        });
    }
}

