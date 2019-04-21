package com.gyk.ders7;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class BiletlerimFragment extends Fragment {

    private ArrayList<Bilet> biletlerim;

    ListView lv_biletlerim;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_biletlerim, container, false);

        lv_biletlerim = v.findViewById(R.id.lv_biletlerim);

        if(getActivity() != null){
           biletlerim = ((MainActivity)getActivity()).satinAlinanBiletListesi;
        }



        return v;
    }
}
