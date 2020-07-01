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

public class GetStarted extends AppCompatActivity {

    Button btn_sign_in, btn_new_account_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_new_account_create = findViewById(R.id.btn_new_account_create);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuju_sign_in = new Intent(GetStarted.this, Sign_In.class);
                startActivity(menuju_sign_in);
            }
        });

        btn_new_account_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuju_register1 = new Intent(GetStarted.this, Register1.class);
                startActivity(menuju_register1);
            }
        });
    }
}
