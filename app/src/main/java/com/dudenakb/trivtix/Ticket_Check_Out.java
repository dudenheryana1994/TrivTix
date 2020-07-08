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
//Deskripsi Pengerjaan : Sudah ada Database

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Ticket_Check_Out extends AppCompatActivity {

    Button btn_buy_ticket, btn_plus, btn_minus;
    TextView text_jumlah_tiket, text_total_harga, text_saldo;
    Integer valuejumlahtiket = 1;
    Integer saldo = 8000;
    Integer valuetotalharga = 0;
    Integer valuehargatiket = 3000;
    ImageView notice_uang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket__check__out);

        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        text_jumlah_tiket = findViewById(R.id.text_jumlah_tiket);
        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        notice_uang = findViewById(R.id.notice_uang);

        text_total_harga = findViewById(R.id.text_total_harga);
        text_saldo = findViewById(R.id.text_saldo);

        // setting valuae baru untuk beberapa komponen
        text_jumlah_tiket.setText(valuejumlahtiket.toString());
        text_saldo.setText("IDR " + saldo);
        valuetotalharga = valuehargatiket * valuejumlahtiket;
        text_total_harga.setText("IDR " + valuetotalharga+"");
        if (valuetotalharga > saldo) {
            btn_buy_ticket.animate().translationY(250).alpha(0).setDuration(350).start();
            btn_buy_ticket.setEnabled(false);

        }

        // secara default, hide btn_minus
        btn_minus.animate().alpha(0).setDuration(300).start();
        btn_minus.setEnabled(false);
        notice_uang.setVisibility(View.GONE);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuejumlahtiket+=1;
                text_jumlah_tiket.setText(valuejumlahtiket.toString());
                if (valuejumlahtiket > 1) {
                    btn_minus.animate().alpha(1).setDuration(300).start();
                    btn_minus.setEnabled(true);
                }
                valuetotalharga = valuehargatiket * valuejumlahtiket;
                text_total_harga.setText("IDR " + valuetotalharga+"");
                if (valuetotalharga > saldo) {
                    btn_buy_ticket.animate().translationY(250).alpha(0).setDuration(350).start();
                    btn_buy_ticket.setEnabled(false);
                    text_saldo.setTextColor(Color.parseColor("#D1206B"));
                    notice_uang.setVisibility(View.VISIBLE);
                }
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuejumlahtiket-=1;
                text_jumlah_tiket.setText(valuejumlahtiket.toString());
                if (valuejumlahtiket < 2) {
                    btn_minus.animate().alpha(0).setDuration(300).start();
                    btn_minus.setEnabled(false);
                }
                valuetotalharga = valuehargatiket * valuejumlahtiket;
                text_total_harga.setText("IDR " + valuetotalharga+"");
                if (valuetotalharga < saldo) {
                    btn_buy_ticket.animate().translationY(0).alpha(1).setDuration(350).start();
                    btn_buy_ticket.setEnabled(true);
                    text_saldo.setTextColor(Color.parseColor("#203DD1"));
                    notice_uang.setVisibility(View.GONE);
                }
            }
        });

        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuju_success_buy_ticket = new Intent(Ticket_Check_Out.this, Success_Buy_Ticket.class);
                startActivity(menuju_success_buy_ticket);
            }
        });
    }
}
