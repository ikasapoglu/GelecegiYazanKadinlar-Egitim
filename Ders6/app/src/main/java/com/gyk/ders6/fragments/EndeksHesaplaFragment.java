package com.gyk.ders6.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gyk.ders6.R;

public class EndeksHesaplaFragment extends Fragment {
    EditText et_kilo, et_boy;
    Button btn_hesapla;
    TextView tv_sonuc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_endekshesapla, container, false);

        et_boy = view.findViewById(R.id.et_endekshesapla_boy);
        et_kilo = view.findViewById(R.id.et_endekshesapla_kilo);
        btn_hesapla = view.findViewById(R.id.btn_endekshesapla_hesapla);
        tv_sonuc = view.findViewById(R.id.tv_endekshesapla_sonuc);

        btn_hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String boy = et_boy.getText().toString();
                String kilo = et_kilo.getText().toString();
                if (!boy.equals("")  && !kilo.equals("") ) {
                    float sonuc = Hesapla(Float.parseFloat(kilo),
                            Float.parseFloat(boy));
                    SonucuEkranaBas(sonuc);
                }
               else {
                   new AlertDialog.Builder(getActivity())
                     .setTitle("hata")
                     .setMessage("eksik bilgi girdiniz")
                     .setNeutralButton("tamam", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {

                         }
                     }) .show();


                }

            }
        });

        return view;
    }

    private float Hesapla(float kilo, float boy) {
        float sonuc;
        boy = boy / 100;
        sonuc = kilo / (boy * boy);
        return sonuc;
    }

    private void SonucuEkranaBas(float sonuc) {
        String message;
        if (sonuc <= 15) {
            message = "Aşırı zayıf";
        } else if (sonuc <= 30) {
            message = "Zayıf";

        } else if (sonuc <= 40) {
            //normal
            message = "Normal";

        } else {
            message = "Aşırı şişman";

            //aşırı şişman obez
        }
        tv_sonuc.setText("Vücut kitle endeksiniz=" + sonuc + "\n" + message);

    }
}


