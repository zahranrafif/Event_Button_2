package com.example.creatinglayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel untuk button
    Button btnLogin;

    //deklrasi variabel untuk EditText
    EditText edemail, edpassword;

    //deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan variabel btnLogin dengan componen button pada Layout
        btnLogin=findViewById(R.id.btSignin);

        //menghubungkan variabel edemail dengan componen button pada layout
        edemail=findViewById(R.id.edEmail);

        //menghubungkan variabel edpassword dengan componen button pada Layout
        edpassword=findViewById(R.id.edPassword);

        //membuat fungsi evem untuk button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menyimpan input user di eddittex email kedalam variabel nama
                nama=edemail.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password=edpassword.getText().toString();

                if (nama.equals("zahran.rafif.ft20@mail.umy.ac.id")&&password.equals("tanyasaya")){
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "Login Berhasil",Toast.LENGTH_LONG).show();

                }
                else if (password.equals("tanyasaya")) {
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "Email yang anda masukkan salah", Toast.LENGTH_LONG).show();

                }
                else if (nama.equals("zahran.rafif.ft20@mail.umy.ac.id")) {
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_LONG).show();
                }
                else {
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Email dan Password Salah").setNegativeButton("Retry", null).create().show();
                }
            }
        });
    }
}