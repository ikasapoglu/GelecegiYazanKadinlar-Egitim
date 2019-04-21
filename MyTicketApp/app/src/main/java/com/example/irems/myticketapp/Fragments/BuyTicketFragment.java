package com.example.irems.myticketapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.irems.myticketapp.Activities.MainActivity;
import com.example.irems.myticketapp.Models.MovieTicket;
import com.example.irems.myticketapp.R;

import java.util.ArrayList;
import java.util.Random;

public class BuyTicketFragment extends Fragment {
    ImageView img_film;
    Button btn_buy;
    TextView txt_filmAdi,txt_filmSeans,txt_filmFiyat;
    ArrayList<MovieTicket> filmListesi=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_buyticket, container, false);
        btn_buy = view.findViewById(R.id.btn_buy);
        img_film = view.findViewById(R.id.img_filmm);
        txt_filmAdi = view.findViewById(R.id.txt_filmmAdi);
        txt_filmSeans = view.findViewById(R.id.txt_filmSeanss);
        txt_filmFiyat = view.findViewById(R.id.txt_filmFiyat);

        if (getActivity() != null) {
            ArrayList<MovieTicket> biletlerim = ((MainActivity) getActivity()).filmListesi;
            final ArrayList<MovieTicket> satinalinanlar = ((MainActivity) getActivity()).satinalinanList;

            final MovieTicket ticket=GetRandomBilet(biletlerim);


        img_film.setImageResource(Integer.valueOf(ticket.getGorsel()));
        txt_filmAdi.setText(String.valueOf(ticket.getFilmAdi()));
        txt_filmSeans.setText(String.valueOf(ticket.getFilmSeans()));
        txt_filmFiyat.setText(String.valueOf(ticket.getFilmFiyat()));

        btn_buy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              satinalinanlar.add(ticket);
                Toast.makeText(getActivity(),"Biletiniz oluşturulmuştur",Toast.LENGTH_LONG).show();
                //startActivity(new Intent(getActivity(), MainActivity.class));

            }
        });
    }

        return view;
    }
    MovieTicket GetRandomBilet(ArrayList<MovieTicket>biletListesi){
        return biletListesi.get(new Random().nextInt(biletListesi.size()));
    }

}
