package com.gyk.ders5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AramaBaslatActivity extends AppCompatActivity {

    EditText et_telefon;
    Button btn_ara;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_aramabaslat);

        btn_ara = findViewById(R.id.btn_aramabaslat_ara);
        et_telefon = findViewById(R.id.et_aramabaslat_no);

        btn_ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telefonNumarasi = et_telefon.getText().toString();
                Arama(telefonNumarasi);

            }
        });
    }

    private void Arama(String telefon) {

        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:" + telefon));
        if(i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }else {
            Toast.makeText(AramaBaslatActivity.this,
                    "Bu işlemi gerçekleştirebilecek bir uygulama yok",
                    Toast.LENGTH_LONG).show();
        }
    }


}
