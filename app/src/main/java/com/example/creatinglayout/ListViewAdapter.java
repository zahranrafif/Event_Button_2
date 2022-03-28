package com.example.creatinglayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    //deklarasi variabel dengan jenis data context
    Context mContext;

    //deklarasi variabel dengan jenis data layout inflater
    LayoutInflater inflater;

    //deklarasi variabel dengan jenis data arraylist
    private ArrayList<ClassNama> arrayList;

    //membuat konstruktor ListViewAdapter
    public ListViewAdapter(Context context){
        //memberi nilai mContext dengan context
        mContext = context;
        //mengatur Layouinflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);
        //memberikan nilai arrayList dari class ClassNama
        this.arrayList = new ArrayList<ClassNama>();
        //menambah semua elemen ke arraylist
        this.arrayList.addAll(Home_Activity.classNamaArrayList);
    }

    //membuat class untuk mendeklarasikan tempat untuk meletakkan isi kedalam listview
    public class ViewHolder{
        //mendeklarasikan variabel dengan jenis TextView
        TextView name;
    }

    //Fungsi getCount() mengembalikan jumlah item yg akan ditampil dalam list
    @Override
    public int getCount() {
        //mengembalikan nilai berupa jumlah data dari array data
        return Home_Activity.classNamaArrayList.size();
    }
    //fungsi ini digunakan untuk mendapatkan daata item yg terkait dengan posisi
    //tertentu dalam kumpulan data untuk medapatkan data yg sesuai dari lokasi
    //tertentu dalam pengumpulan data item.S
    @Override
    public Object getItem(int i) {
        //mengembalikan nilai berupa objek dari array data
        return Home_Activity.classNamaArrayList.get(i);
    }
    //fungsi mengemnalikan nilai dari posisi item ke adaptor
    @Override
    public long getItemId(int i) {
        return i;
    }
    //fungsi ini secara otomatis dipanggil ketika tampilan item list siap untuk
    //ditampilkan atau akan ditampil
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //deklarasi variabel dengan jenis data ViewHolder
        final ViewHolder holder;

        //membuat kondisi apakah view null atau tidak
        if (view==null) {
            //membuat objek view holder
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_listview, null);

            //set id untuk textview
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);
            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain.
            view.setTag(holder);

        }else{
            //mengatur holder untuk mengembalikan nilai dari view tag.
            holder = (ViewHolder) view.getTag();
        }
        //set item ke textviews
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());
        return view;
    }
}
