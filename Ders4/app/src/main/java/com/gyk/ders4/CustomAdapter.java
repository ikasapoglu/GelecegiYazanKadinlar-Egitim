package com.gyk.ders4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Ogrenci> ogrenciListe;

    public CustomAdapter(Context _context, ArrayList<Ogrenci> _ogrenciListe) {
        this.context = _context;
        this.ogrenciListe = _ogrenciListe;
    }

    @Override
    public int getCount() {
        return ogrenciListe.size();
    }

    @Override
    public Object getItem(int position) {
        return ogrenciListe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final View v = View.inflate(context, R.layout.listitem_ogrenci, null);

        ImageView iv_profil = v.findViewById(R.id.iv_profil);
        TextView tv_isim = v.findViewById(R.id.tv_ogrencisim);
        TextView tv_okulismi  = v.findViewById(R.id.tv_okuladi);


        iv_profil.setImageResource(ogrenciListe.get(position).resimUrl);
        tv_isim.setText(ogrenciListe.get(position).isim);
        tv_okulismi.setText(ogrenciListe.get(position).okulismi);

        return v;
    }
}
