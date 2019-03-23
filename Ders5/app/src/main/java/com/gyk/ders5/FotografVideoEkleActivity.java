package com.gyk.ders5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class FotografVideoEkleActivity extends AppCompatActivity {

    private static final int FOTOGRAF_ISTEKKOD = 99;
    private static final int VIDEO_ISTEKKOD = 123;

    Button btn_fotografcek, btn_videocek;
    ImageView iv_fotograf;
    VideoView videoview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        btn_fotografcek = findViewById(R.id.btn_camera_fotografcek);
        btn_videocek = findViewById(R.id.btn_camera_videokayit);
        iv_fotograf = findViewById(R.id.iv_camera_fotograf);
        videoview = findViewById(R.id.videoview_camera_video);


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

    void FotografCek() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, FOTOGRAF_ISTEKKOD);
    }

    void VideoCek() {
        Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(i, VIDEO_ISTEKKOD);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) return;

        if (requestCode == FOTOGRAF_ISTEKKOD) {
            if (data != null) {
                Bundle bundle = data.getExtras();
                iv_fotograf.setImageBitmap((Bitmap) bundle.get("data"));
            }
        } else if (requestCode == VIDEO_ISTEKKOD) {
            if (data != null) {
                videoview.setVideoURI(data.getData());
                videoview.setMediaController(new MediaController(FotografVideoEkleActivity.this));
                videoview.requestFocus();
                videoview.start();
            }
        }
    }
}
