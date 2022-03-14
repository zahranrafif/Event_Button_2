package com.example.creatinglayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Membuat kondisi jika dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar)
        {
            //Method untuk memanggil activity "DaftarActivity"
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        else if (item.getItemId() == R.id.mlogout)
        {
            //Method untuk memanggil activity "DaftarActivity"
            Toast.makeText(MainActivity.this, "Anda dikeluarkan", Toast.LENGTH_SHORT).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    //ini adalah project yang dipakai untuk 4 activity

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
                //Menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();
                //Menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                String Email="zahran@gmail.com";
                String pass="tanyajaran";

                //Mengecek apakah edittext email dan password sesuai atau tidak (valid atau tidak) isinya
                if (nama.equals(Email) && password.equals(pass)){
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                    //inisiasi
                    Bundle bn = new Bundle();

                    //memasukkan value dari variabel nama dengan kunci "a" dan dimasukkan kedalam bundle
                    bn.putString("a", nama.trim());

                    //memasukkan value dari variabel password dengan kunci "b" dan dimasukkan kedalam bundle
                    bn.putString("b", password.trim());

                    //membuat objek intent berpindah activity dari mainactivity ke ActivityKedua
                    Intent i = new Intent(MainActivity.this,ActivityKedua.class);

                    //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityKedua
                    i.putExtras(bn);

                    //berpindah ke ActivityKedua
                    startActivity(i);
                }
                else if (password.equals(pass)){
                    //jika Email salah
                    Toast.makeText(MainActivity.this, "Email yang anda masukkan salah", Toast.LENGTH_SHORT).show();
                }
                else if (nama.equals(Email)){
                    //jika Password salah
                    Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
                }
                else {
                    //jika email dan password salah
                    Toast.makeText(MainActivity.this, "Email dan Password Anda Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}