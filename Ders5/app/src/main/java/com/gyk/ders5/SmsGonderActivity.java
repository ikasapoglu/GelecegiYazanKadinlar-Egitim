package com.gyk.ders5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsGonderActivity extends AppCompatActivity {

    EditText et_mesaj, et_telefonNo;
    Button btn_smsgonder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsgonder);

        et_mesaj = findViewById(R.id.et_sms_mesaj);
        et_telefonNo = findViewById(R.id.et_sms_telefon);
        btn_smsgonder = findViewById(R.id.btn_sms_gonder);

        btn_smsgonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mesaj = et_mesaj.getText().toString();
                String telefonNo = et_telefonNo.getText().toString();
                SmsGonder(mesaj, telefonNo);
            }
        });
    }

    void SmsGonder(String mesaj, String telefonNo) {
        Uri uri = Uri.parse("smsto:" + telefonNo);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", mesaj);
        startActivity(intent);
    }
}
