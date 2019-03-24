package com.gyk.ders5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SesKaydetActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_kaydet, btn_durdur, btn_cal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seskaydet);

        btn_kaydet = findViewById(R.id.btn_seskaydet_kaydet);
        btn_durdur = findViewById(R.id.btn_seskaydet_durdur);
        btn_cal = findViewById(R.id.btn_seskaydet_cal);
        btn_kaydet.setOnClickListener(this);
        btn_durdur.setOnClickListener(this);
        btn_cal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btn_kaydet) {
            KaydiBaslat();
        } else if (v == btn_cal) {
            SesiCal();
        } else if (v == btn_durdur) {
            SesiDurdur();
        }
    }

    private void SesiDurdur() {
    }

    private void SesiCal() {
    }

    private void KaydiBaslat() {
    }
}
