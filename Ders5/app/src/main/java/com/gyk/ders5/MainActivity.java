package com.gyk.ders5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_fotografvideoekle, btn_seskayit, btn_haritayaGit, btn_webeGit, btn_smsGonder, btn_aramaYap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_fotografvideoekle = findViewById(R.id.btn_main_fotografvideoekle);
        btn_seskayit = findViewById(R.id.btn_main_seskayit);
        btn_haritayaGit = findViewById(R.id.btn_main_haritayagit);
        btn_webeGit = findViewById(R.id.btn_main_websayfasinagit);
        btn_smsGonder = findViewById(R.id.btn_main_smsgonder);
        btn_aramaYap = findViewById(R.id.btn_main_aramayap);

        btn_fotografvideoekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        MainActivity.this, FotografVideoEkleActivity.class);
                startActivity(i);
            }
        });
    }
}
