package com.gyk.ders7;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class BiletSatinAlFragment extends Fragment {

    private TextView tv_biletAd, tv_biletNo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_biletsatinal, container, false);

        tv_biletAd = v.findViewById(R.id.tv_biletsatinal_biletAdi);
        tv_biletNo = v.findViewById(R.id.tv_biletsatinal_biletno);

        if(getActivity() != null){
           ArrayList<Bilet> biletlerim = ((MainActivity)getActivity()).biletList;

           Bilet bilet = GetRandomBilet(biletlerim);

           tv_biletAd.setText(String.valueOf(bilet.ucret));
           tv_biletNo.setText(String.valueOf(bilet.ad));
        }

        return v;
    }

    private Bilet GetRandomBilet(ArrayList<Bilet> biletList){
        return biletList.get(new Random().nextInt(biletList.size()));
    }

}
