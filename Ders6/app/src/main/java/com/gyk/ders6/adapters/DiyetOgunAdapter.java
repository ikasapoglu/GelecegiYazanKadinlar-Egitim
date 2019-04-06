package com.gyk.ders6.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyk.ders6.R;
import com.gyk.ders6.models.DiyetOgun;

import java.util.ArrayList;

public class DiyetOgunAdapter extends BaseAdapter {

    Context context;
    ArrayList<DiyetOgun> diyetOgunList;
    LayoutInflater inflater;

    public DiyetOgunAdapter(Context context, ArrayList<DiyetOgun> diyetOgunList, LayoutInflater layoutInflater) {
        this.context = context;
        this.diyetOgunList = diyetOgunList;
        this.inflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return diyetOgunList.size();
    }

    @Override
    public Object getItem(int position) {
        return diyetOgunList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.listitem_yemek, null);
        ImageView iv_yemekGorsel = v.findViewById(R.id.iv_yemek);
        TextView tv_yemekAdi = v.findViewById(R.id.tv_yemek_adi);
        TextView tv_yemekKalori  = v.findViewById(R.id.tv_yemek_kalori);

        DiyetOgun diyetOgun = diyetOgunList.get(position);

        iv_yemekGorsel.setImageResource(diyetOgun.getGorsel());
        tv_yemekAdi.setText(diyetOgun.getBesinIcerik());
        tv_yemekKalori.setText(diyetOgun.getKaloriDegeri());

        return v;
    }
}
