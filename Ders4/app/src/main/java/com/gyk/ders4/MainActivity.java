package com.gyk.ders4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv_ogrenciler;
    private ArrayList<Ogrenci> ogrenciListesi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_ogrenciler = findViewById(R.id.lv_main_ogrenciler);


        ogrenciListesi.add(new Ogrenci(R.drawable.stone, "Ayşe", "İstanbul Üniversitesi"));
        ogrenciListesi.add(new Ogrenci(R.drawable.stthree, "İbrahim", "İstanbul Üniversitesi"));
        ogrenciListesi.add(new Ogrenci(R.drawable.sttwo, "Selma", "Marmara Üniversitesi"));
        ogrenciListesi.add(new Ogrenci(R.drawable.stthree, "Ayşe", "İstanbul Üniversitesi"));
        ogrenciListesi.add(new Ogrenci(R.drawable.sttwo, "Ayşe", "İstanbul Üniversitesi"));

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, ogrenciListesi);

        lv_ogrenciler.setAdapter(customAdapter);


    }
}
