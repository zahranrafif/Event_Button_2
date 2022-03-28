package com.example.creatinglayout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLihatData extends AppCompatActivity {
    //deklarasi variabel dengan jenis data TextView
    TextView tvnama, tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

    //Menghubungkan variabel
    tvnama = findViewById(R.id.tvNamaKontak);
    tvnomor = findViewById(R.id.tvNomorTelepon);

    //membuat variabel dengan jenis data bundle dan
    //assign value dari
    //getIntent().getExtras()
    Bundle bundle = getIntent().getExtras();

    //membuat variabel nama dan assign value dari pesan
    //yang dikirimkan dari activity sebelumnya
    String nama = bundle.getString("a");

        //buat code kirim intent
        switch (nama) {
            case "Inayah":
                tvnama.setText("Inayah M");
                tvnomor.setText("08122233344");
                break;
            case "Zahran":
                tvnama.setText("Ilham R");
                tvnomor.setText("089651509087");
                break;
            case "Maul":
                tvnama.setText("Mau Maulana");
                tvnomor.setText("089675643546");
                break;
            case "Intan":
                tvnama.setText("Intan Sabrina");
                tvnomor.setText("089644643523");
                break;
            case "Rafli":
                tvnama.setText("Rafli Ramadhani");
                tvnomor.setText("089644233500");
                break;
            case "Inggit":
                tvnama.setText("Inggit Prasetyo");
                tvnomor.setText("089644333554");
                break;
            case "Bagas":
                tvnama.setText("Bagas Bayu Bismantaka");
                tvnomor.setText("089124333533");
        }
    tvnama.setText(nama);
    }
}

