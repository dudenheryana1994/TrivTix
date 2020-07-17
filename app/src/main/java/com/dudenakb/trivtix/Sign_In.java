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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Sign_In extends AppCompatActivity {

    TextView btn_new_account;
    Button btn_sign_in;
    EditText username_sign_in, password_sign_in;
    DatabaseReference reference;
    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String getUsername_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__in);

        btn_new_account = findViewById(R.id.btn_new_account);
        btn_sign_in = findViewById(R.id.btn_sign_in);
        username_sign_in = findViewById(R.id.username_sign_in);
        password_sign_in = findViewById(R.id.password_sign_in);

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

                //ubah state menjadi loading
                btn_sign_in.setEnabled(false);
                btn_sign_in.setText("loading ...");

                final String username = username_sign_in.getText().toString();
                final String password = password_sign_in.getText().toString();

                if (username.isEmpty()){
                    Toast.makeText(getApplicationContext(), "username tidak boleh kosong !", Toast.LENGTH_SHORT).show();
                    //merubah state
                    btn_sign_in.setEnabled(true);
                    btn_sign_in.setText("SIGN IN");
                }
                else {
                    if (password.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Password tidak boleh kosong !", Toast.LENGTH_SHORT).show();
                        //merubah state
                        btn_sign_in.setEnabled(true);
                        btn_sign_in.setText("SIGN IN");
                    }
                    else {
                        reference = FirebaseDatabase.getInstance().getReference().child("Users").child(username);

                        reference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()){

                                    //mengambil data password dari firebase
                                    String passwordFromFirebase = dataSnapshot.child("password").getValue().toString();

                                    //validasi password dengan password firebase
                                    if (password.equals(passwordFromFirebase)){

                                        //simpan username key kapada local
                                        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString(username_key, username_sign_in.getText().toString());
                                        editor.apply();

                                        //berpindah activity
                                        Intent menuju_home = new Intent(Sign_In.this, Home.class);
                                        startActivity(menuju_home);
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), "Password Salah!", Toast.LENGTH_SHORT).show();
                                        //merubah state
                                        btn_sign_in.setEnabled(true);
                                        btn_sign_in.setText("SIGN IN");
                                    }

                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Username Salah!", Toast.LENGTH_SHORT).show();
                                    //merubah state
                                    btn_sign_in.setEnabled(true);
                                    btn_sign_in.setText("SIGN IN");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Toast.makeText(getApplicationContext(), "Database Error!", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                }
            }
        });
    }
}

