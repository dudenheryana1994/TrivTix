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

public class Ticket_Detail extends AppCompatActivity {

    Button btn_buy_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket__detail);

        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);

        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuju_ticket_ceck_out = new Intent(Ticket_Detail.this, Ticket_Check_Out.class);
                startActivity(menuju_ticket_ceck_out);
            }
        });
    }
}
