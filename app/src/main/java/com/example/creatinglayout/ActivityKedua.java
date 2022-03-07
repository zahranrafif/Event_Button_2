package com.example.creatinglayout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityKedua extends AppCompatActivity {
    //mendeklarasikan variabel dengan tipe data TextView
    TextView txEmail, txPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        //Menghubungkan variabel txEmail dengan componen TextView pada Layout
        txEmail = findViewById(R.id.tvEmail3);

        //Menghubungkan variabel txPassword dengan componen TextView pada Layout
        txPassword = findViewById(R.id.tvPassword);

        //membuat objek bundle dan mengambil data yang dikirimkan dari activity sebelumnya
        Bundle bundle = getIntent().getExtras();

        //Membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari activity sebelumnya dengan kunci "a"
        String email = bundle.getString("a");

        //Membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari activity sebelumnya dengan kunci "b"
        String pass = bundle.getString("b");

        //menampilkan value dari variabel email kedalam txEmail
        txEmail.setText(email);

        //menampilkan value dari variabel pass kedalam txPassword
        txPassword.setText(pass);
    }
}
