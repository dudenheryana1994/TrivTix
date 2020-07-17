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
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyTicket_Detail extends AppCompatActivity {

    ImageView btn_back;
    TextView xnama_wisata, xlokasi, xtanggal_wisata, xwaktu_wisata, xketentuan;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ticket__detail);

        btn_back = findViewById(R.id.btn_back);

        xnama_wisata = findViewById(R.id.xnama_wisata);
        xlokasi = findViewById(R.id.xlokasi);
        xtanggal_wisata = findViewById(R.id.xtanggal_wisata);
        xwaktu_wisata = findViewById(R.id.xwaktu_wisata);
        xketentuan = findViewById(R.id.xketentuan);

        //mengambil data dari intent
        Bundle bundle = getIntent().getExtras();
        final String nama_wisata_baru = bundle.getString("nama_wisata");

        //mengambil data dari firebase
        reference = FirebaseDatabase.getInstance().getReference().child("Wisata").child(nama_wisata_baru);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                xnama_wisata.setText(dataSnapshot.child("nama_wisata").getValue().toString());
                xlokasi.setText(dataSnapshot.child("lokasi").getValue().toString());
                xtanggal_wisata.setText(dataSnapshot.child("tanggal_wisata").getValue().toString());
                xwaktu_wisata.setText(dataSnapshot.child("waktu_wisata").getValue().toString());
                xketentuan.setText(dataSnapshot.child("ketentuan").getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali_ke_profile = new Intent(MyTicket_Detail.this, MyProfile.class);
                startActivity(kembali_ke_profile);
            }
        });
    }
}
