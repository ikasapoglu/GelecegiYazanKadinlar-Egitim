package com.example.irems.myticketapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.irems.myticketapp.Models.MovieTicket;
import com.example.irems.myticketapp.R;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    Context context;
    ArrayList<MovieTicket> filmList;
    LayoutInflater inflater;

    public FilmAdapter(Context context, ArrayList<MovieTicket> filmList, LayoutInflater inflater) {
        this.context = context;
        this.filmList = filmList;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return filmList.size();
    }

    @Override
    public Object getItem(int position) {
        return filmList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=inflater.inflate(R.layout.layout_design,null);
        ImageView iv_filmGorsel=v.findViewById(R.id.img_filmm);
        TextView tv_filmAdi=v.findViewById(R.id.txt_filmadi);
        TextView tv_filmSeans=v.findViewById(R.id.txt_seans);
        TextView tv_filmFiyat=v.findViewById(R.id.txt_filmFiyat);

        MovieTicket myticket=filmList.get(position);

        iv_filmGorsel.setImageResource(myticket.getGorsel());
        tv_filmAdi.setText(myticket.getFilmAdi());
        tv_filmSeans.setText(myticket.getFilmSeans());
        tv_filmFiyat.setText(myticket.getFilmFiyat());
        return v;
    }
}
