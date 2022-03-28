package com.example.creatinglayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    //deklarasi variabel dengan jenis data listview
    private ListView list;

    //memanggil class ListViewAdapter dan diinisiasi menjadi9 variabel adapter
    private ListViewAdapter adapter;

    //deklrasi array untuk menyimpan nama
    String[] listNama;

    //memanggil class CmassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //membuat objek bundle
    Bundle bundle = new Bundle();
    //membuat objek intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //menyimpan nama didalam array listnama
        listNama = new String[]{"Inayah","Zahran","Zidhan","Maul",
        "Intan","Rafli","Inggit","Bagas","Zulux"};

        list= findViewById(R.id.listKontak);
        //membuat onjek dari class ClassNama menjadi arraylist
        classNamaArrayList = new ArrayList<>();
        //membaca seluruh data pada array listnama
        for (int i = 0; i < listNama.length; i++)
        {
            //membuat objek class nama do
            ClassNama classNama = new ClassNama(listNama[i]);
            //binds strings ke array
            classNamaArrayList.add(classNama);
        }
        //membuat objek dari listviewadapter
        adapter = new ListViewAdapter(this);
        //binds adapter ke listview
        list.setAdapter(adapter);

        //membuat event dari list onClick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //deklarasi variabel nama yg berisi item yg di klik
                String nama=classNamaArrayList.get(position).getName();
                //memasukkan value dari variabel nama dengan kunci "a"
                //dandimasukkan kedalam bundle
                bundle.putString("a",nama.trim());
                //membuat objek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                //membuat event popup menu ketika dipilih
                pm.setOnMenuItemClickListener(Home_Activity.this);
                //menampilkan popup menu dari layout menu
                pm.inflate(R.menu.popup_menu);
                //menampilkan popup menu
                pm.show();
            }
        });
    }
    //event yang terjadi ketika menu dipilih
    @Override
    public boolean onMenuItemClick(MenuItem menuItem){
        switch (menuItem.getItemId()) {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(), "Ini untuk edit kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}
