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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class Register2 extends AppCompatActivity {

    ImageView btn_back, btn_add_photo, pic_photo_register_user;
    Button btn_continue;
    TextView nama_lengkap, hobby;

    Uri photo_location;
    Integer photo_max = 1;

    DatabaseReference reference;
    StorageReference storage;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String getUsername_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        getUsernameLocal();

        btn_continue = findViewById(R.id.btn_continue);
        btn_back = findViewById(R.id.btn_back);
        btn_add_photo = findViewById(R.id.btn_add_photo);
        pic_photo_register_user = findViewById(R.id.pic_photo_register_user);
        nama_lengkap = findViewById(R.id.nama_lengkap);
        hobby = findViewById(R.id.hobby);

        btn_add_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findPhoto();
            }
        });

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ubah state menjadi loading
                btn_continue.setEnabled(false);
                btn_continue.setText("loading ...");

                //menyimpan kepada firebase
                reference = FirebaseDatabase.getInstance().getReference().child("Users").child(getUsername_key_new);
                storage = FirebaseStorage.getInstance().getReference().child("PhotoUser").child(getUsername_key_new);

                //validasi untuk file
                if (photo_location != null){
                    final StorageReference storageReference1 = storage.child(System.currentTimeMillis() + "." + getFileExtention(photo_location));
                    storageReference1.putFile(photo_location).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            storageReference1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String uri_photo = uri.toString();
                                    reference.getRef().child("url_photo_profile").setValue(uri_photo);
                                    reference.getRef().child("nama_lengkap").setValue(nama_lengkap.getText().toString());
                                    reference.getRef().child("hobby").setValue(hobby.getText().toString());

                                }
                            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    //berpindah activity
                                    Intent menuju_success_register = new Intent(Register2.this, Success_Register.class);
                                    startActivity(menuju_success_register);
                                }
                            });

                        }
                    }).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                        }
                    });
                }

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali_ke_register1 = new Intent(Register2.this, Register1.class);
                startActivity(kembali_ke_register1);
            }
        });
    }

    String getFileExtention(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    public void findPhoto(){
        Intent pic = new Intent();
        pic.setType("image/*");
        pic.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(pic, photo_max);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == photo_max && resultCode == RESULT_OK && data != null && data.getData() != null) {

            photo_location = data.getData();
            Picasso.with(this).load(photo_location).centerCrop().fit().into(pic_photo_register_user);
        }
    }

    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        getUsername_key_new = sharedPreferences.getString(username_key, "");
    }

}
