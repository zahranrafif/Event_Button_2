package com.example.creatinglayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DaftarActivity extends AppCompatActivity {

    //Deklrasi variabel dengan tipe data EditText
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtepass;

    //Deklarasi variabel dengan tipe data Floating action button
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_activity);

        edtNama = findViewById(R.id.edNama);
        edtEmail = findViewById(R.id.edEmail2);
        edtPassword = findViewById(R.id.edPass);
        edtepass = findViewById(R.id.edrepas);
        edtAlamat = findViewById(R.id.edAlamat);

        fab = findViewById(R.id.fabSimpan);

        //membuat method untuk event dari floating button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtepass.getText().toString().isEmpty())
                {
                    //Menampilkan pesan notifikawsi jika seluruh Edittext wajib diisi
                    Snackbar.make(v, "Wajib isi seluruh data !!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    //Membuat kondisi untuk mengecek apakah isi dari EditText password dan EditText repassword sama atau tidak
                    if (edtPassword.getText().toString().equals(edtepass.getText().toString()))
                    {
                        //Menampilkan pesan notifikasi jika pendaftaran berhasil
                        Toast.makeText(getApplicationContext(), "Pendaftaran Behasil...",
                                Toast.LENGTH_LONG).show();

                        //Method untuk kembali ke activity Main
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        //Menampilkan pesan bahwa isi dari EditText password dan EditText repassword tidak sama
                        Snackbar.make(v, "Password dan Repassword harus sama!!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
