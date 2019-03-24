package com.gyk.ders5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_fotografvideoekle, btn_seskayit, btn_haritayaGit, btn_webeGit, btn_smsGonder, btn_aramaYap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_fotografvideoekle = findViewById(R.id.btn_main_fotografvideoekle);
        btn_fotografvideoekle.setOnClickListener(this);
        btn_seskayit = findViewById(R.id.btn_main_seskayit);
        btn_seskayit.setOnClickListener(this);

        btn_haritayaGit = findViewById(R.id.btn_main_haritayagit);
        btn_haritayaGit.setOnClickListener(this);

        btn_webeGit = findViewById(R.id.btn_main_websayfasinagit);
        btn_webeGit.setOnClickListener(this);

        btn_smsGonder = findViewById(R.id.btn_main_smsgonder);
        btn_smsGonder.setOnClickListener(this);

        btn_aramaYap = findViewById(R.id.btn_main_aramayap);
        btn_aramaYap.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btn_fotografvideoekle) {
            Intent i = new Intent(
                    MainActivity.this, FotografVideoEkleActivity.class);
            startActivity(i);
        } else if (v == btn_haritayaGit) {
            Intent i = new Intent(
                    MainActivity.this, HaritaActivity.class);
            startActivity(i);
        }
        else if (v == btn_smsGonder)
        {
            Intent i = new Intent(
                    MainActivity.this, SmsGonderActivity.class);
            startActivity(i);
        }

        else if ( v == btn_aramaYap)
        {
            Intent i = new Intent(
                    MainActivity.this, AramaBaslatActivity.class);
            startActivity(i);
        }
    }
}
