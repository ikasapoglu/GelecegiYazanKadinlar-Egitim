package com.example.irems.myticketapp.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.irems.myticketapp.Models.MovieTicket;
import com.example.irems.myticketapp.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button btn_login, btn_kayitol;
    EditText et_user, et_password;

    private FirebaseAuth mAuth;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btn_login = findViewById(R.id.btn_login);
        btn_kayitol = findViewById(R.id.btn_login_kayitol);
        et_user = findViewById(R.id.txt_user);
        et_password = findViewById(R.id.txt_password);


        mAuth =  FirebaseAuth.getInstance();

        btn_kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = et_user.getText().toString();
                String password = et_password.getText().toString();
                if (!user.equals("") && !password.equals("")) {
                    Log.d("app1",user+"-"+password);
                    if (user.equals("GYK")&& password.equals("3422")) {
                       Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                       startActivity(intent);

                    } else {
                        new AlertDialog.Builder(LoginActivity.this)
                                .setTitle("hata")
                                .setMessage("Girmiş olduğunuz bilgilerde kullanıcı bulunamadı.")
                                .setNeutralButton("tamam", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).show();


                    }

                } else {
                    new android.app.AlertDialog.Builder(LoginActivity.this)
                            .setTitle("hata")
                            .setMessage("eksik bilgi girdiniz")
                            .setNeutralButton("tamam", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).show();

                }

            }
        });


    }
}
