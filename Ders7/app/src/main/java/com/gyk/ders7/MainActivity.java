package com.gyk.ders7;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Bilet> satinAlinanBiletListesi;
    public ArrayList<Bilet> biletList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        biletList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Bilet b = new Bilet("Nemo: " + new Random().nextInt(),new Random().nextInt(100 - 20) + 20,
                    Math.abs(new Random().nextLong()));
            biletList.add(b);
        }

        findViewById(R.id.btn_biletsatinalac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                t.replace(R.id.container, new BiletSatinAlFragment());
                t.commit();
            }
        });


    }

    public void cagirrr(){}
}
