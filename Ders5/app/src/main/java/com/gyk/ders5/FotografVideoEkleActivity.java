package com.gyk.ders5;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FotografVideoEkleActivity extends AppCompatActivity {

    Button btn_fotografcek, btn_videocek;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        btn_fotografcek = findViewById(R.id.btn_camera_fotografcek);
        btn_videocek = findViewById(R.id.btn_camera_videokayit);



        btn_fotografcek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FotografCek();
            }
        });

        btn_videocek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoCek();
            }
        });
    }

    void FotografCek(){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 99);
    }

    void VideoCek(){

    }

}
