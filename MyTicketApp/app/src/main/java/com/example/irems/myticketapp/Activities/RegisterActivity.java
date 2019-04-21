package com.example.irems.myticketapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.irems.myticketapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText et_adgiris, et_mailgiris, et_sifregiris;
        Button bt_kayitol;
        CheckBox cb_onay;
        et_adgiris = (EditText) findViewById(R.id.et_adgiris);
        et_mailgiris = (EditText) findViewById(R.id.et_emailgiris);
        et_sifregiris = (EditText) findViewById(R.id.et_sifregiris);

        bt_kayitol = (Button) findViewById(R.id.btn_kayitol);
        cb_onay = (CheckBox) findViewById(R.id.cb_sozlesme);


        mAuth = FirebaseAuth.getInstance();

        bt_kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = et_adgiris.getText().toString();
                final String password = et_sifregiris.getText().toString();
                final String mail = et_mailgiris.getText().toString();

                if (checkForm(name, password, mail)) {

                    mAuth.createUserWithEmailAndPassword(mail, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this,
                                                "Kayıt işlemi başarılı", Toast.LENGTH_LONG).show();
                                        FirebaseUser user = mAuth.getCurrentUser();
                                    } else {
                                        System.out.println("başarısız kayıt!!!!! : " + task.getException());
                                        Toast.makeText(RegisterActivity.this,
                                                "Kayıt işlemi başarısız", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                    //startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                } else {
                    System.out.println("Yanlış giriş yapıldı.");
                    //Todo: toast mesajı çıkar
                }

            }
        });
    }

    public Boolean checkForm(String... data) {
        for (String str : data) {
            if (str == null || str.trim().equals("")) {
                return false;
            }
        }
        return true;
    }
}
