package com.gyk.ders6;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class DiyetListesiFragment extends Fragment {

    ListView lv_yemek;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_yemek_listesi, container, false);

        lv_yemek = view.findViewById(R.id.lv_yemeklist);
        
        return view;
    }



}
