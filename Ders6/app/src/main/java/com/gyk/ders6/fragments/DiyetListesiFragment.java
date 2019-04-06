package com.gyk.ders6.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gyk.ders6.R;
import com.gyk.ders6.adapters.DiyetOgunAdapter;
import com.gyk.ders6.models.DiyetOgun;

import java.util.ArrayList;

public class DiyetListesiFragment extends Fragment {

    ListView lv_yemek;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_yemek_listesi, container, false);
        lv_yemek = view.findViewById(R.id.lv_yemeklist);

        ArrayList<DiyetOgun> diyetOgunListesi = new ArrayList<>();
        diyetOgunListesi.add(new DiyetOgun(R.drawable.menu_1, "Kivi, kiraz, Armut","600C"));
        diyetOgunListesi.add(new DiyetOgun(R.drawable.menu_2, "Köfte, Tavuk Suyu, Çilek","600C"));
        diyetOgunListesi.add(new DiyetOgun(R.drawable.menu_3, "Ananas, pilav, Armut","600C"));
        diyetOgunListesi.add(new DiyetOgun(R.drawable.menu_4, "Ceviz, kiraz, Armut","600C"));

        DiyetOgunAdapter adapter = new DiyetOgunAdapter(getActivity(), diyetOgunListesi, inflater);
        lv_yemek.setAdapter(adapter);

        return view;
    }
}
