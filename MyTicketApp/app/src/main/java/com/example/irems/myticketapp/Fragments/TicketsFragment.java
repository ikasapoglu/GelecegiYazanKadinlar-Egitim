package com.example.irems.myticketapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.irems.myticketapp.Activities.MainActivity;
import com.example.irems.myticketapp.Models.MovieTicket;
import com.example.irems.myticketapp.R;
import com.example.irems.myticketapp.adapter.FilmAdapter;

import java.util.ArrayList;

public class TicketsFragment extends Fragment {
    ListView lv_ticket;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.ticket,container,false);

        lv_ticket = view.findViewById(R.id.listView);

        ArrayList<MovieTicket> filmListesi = ((MainActivity) getActivity()).satinalinanList;



        FilmAdapter adapter=new FilmAdapter(getActivity(),filmListesi,inflater);
        lv_ticket.setAdapter(adapter);


        return view;
    }
}
