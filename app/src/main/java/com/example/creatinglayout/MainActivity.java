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
            Intent i = new Intent(getApplicationContext(), Home_Activity.class);
            startActivity(i);
        }
        else if (item.getItemId() == R.id.mlogout)
        {
            Toast.makeText(MainActivity.this, "Anda dikeluarkan", Toast.LENGTH_SHORT).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    Button btnLogin;
    EditText edemail, edpassword;
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.btSignin);
        edemail=findViewById(R.id.edEmail);
        edpassword=findViewById(R.id.edPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edemail.getText().toString();

                password = edpassword.getText().toString();

                String Email="zahranrafif";
                String pass="tanyajaran";


                if (nama.isEmpty()){
                    edemail.setError("Nama diperlukan");
                }
                else if (password.isEmpty()){
                    edpassword.setError("Password Diperlukan");
                    Toast.makeText(MainActivity.this, "Password Harus Diisi", Toast.LENGTH_SHORT).show();
                }
                else if (nama.equals(Email) && password.equals(pass)){
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                    Bundle bn = new Bundle();

                    bn.putString("a", nama.trim());

                    Intent i = new Intent(MainActivity.this,Home_Activity.class);

                    i.putExtras(bn);

                    startActivity(i);
                }
                else if (password.equals(pass)){
                    Toast.makeText(MainActivity.this, "Email yang anda masukkan salah", Toast.LENGTH_SHORT).show();
                }
                else if (nama.equals(Email)){
                    Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(MainActivity.this, "Email dan Password Anda Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}