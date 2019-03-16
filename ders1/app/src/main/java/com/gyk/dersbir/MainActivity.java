package com.gyk.dersbir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Bu activity sınıfına ait fieldları tanımlıyoruz.
    // Dikkat edilmesi gereken husus; herhangi bir atama yapılmadığı takdirde bu şekilde bırakırsak eğer pointer değerleri "null" olacaktır.
    private ImageView iv_appIcon;
    private EditText et_kullaniciAdi;
    private EditText et_sifre;
    private Button btn_girisYap;
    private TextView tv_gyk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findviewbyid metodu ile(Bu metod classın super'i olan AppCompatActivity sınıfından gelmektedir) componentları layout dosyamızda yer alan id'leri ile eşleştiriyoruz.
        iv_appIcon = findViewById(R.id.iv_main_appicon);
        et_kullaniciAdi = findViewById(R.id.et_main_kullaniciad);
        et_sifre = findViewById(R.id.et_main_sifre);
        btn_girisYap = findViewById(R.id.btn_main_giris);
        tv_gyk = findViewById(R.id.tv_main_gykbottom);


        //Butonun tıklaanabilirlik özelliğini(Interface) "Inline Implement" ederek handle işlemini gerçekleştiriyoruz.
        btn_girisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputKullaniciAd = et_kullaniciAdi.getText().toString();
                String inputSifre = et_sifre.getText().toString();

                if (inputKullaniciAd.equals("gyk")
                        && inputSifre.equals("123")) {

                    /*Kullanıcı adı ve şifre doğru ise ToDoList activity'sini kullanmak üzere bir "intent" nesnesi oluşturuyor,
                    "AppCompatActivity(Super class)'den sağlanan "startActivity" metodu ile belirlediğimiz intent'i ekrana basıyoruz.*/
                    Intent i = new Intent(MainActivity.this,
                            TodoListActivity.class);
                    startActivity(i);

                } else {
                   //TODO: Burada kullanıcının hatalı giriş yaptığını bildiren bir AlertDialog gösterelim.
                }
            }
        });
    }
}
