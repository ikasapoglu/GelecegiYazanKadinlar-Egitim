package com.gyk.ders7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class BiletlerimAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Bilet> biletList;
    private LayoutInflater layoutInflater;

    public BiletlerimAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Bilet> biletList) {
        this.context = context;
        this.layoutInflater = layoutInflater;
        this.biletList = biletList;
    }

    @Override
    public int getCount() {
        return biletList.size();
    }

    @Override
    public Object getItem(int position) {
        return biletList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
