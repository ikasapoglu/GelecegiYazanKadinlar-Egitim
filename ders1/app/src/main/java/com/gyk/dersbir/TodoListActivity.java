package com.gyk.dersbir;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TodoListActivity extends AppCompatActivity {

    //Meyve listesi oluşturuyoruz, daha sonra bu nesneye itemlar ekleyeceğiz.
    ArrayList<String> meyveListesi = new ArrayList<String>();

    ListView lv_meyveler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        lv_meyveler = findViewById(R.id.lv_todolist_meyvelist);

        //"Meyve Listesi" adlı listemize gerekli değer eklemelerini gerçekleştiriyoruz.
        meyveListesi.add("Elma");
        meyveListesi.add("Armut");
        meyveListesi.add("Portakal");
        meyveListesi.add("Kiraz");
        meyveListesi.add("Ananas");

/*       Bir array adapter nesnesi oluşturuyoruz ve sırasıyla; hangi contexte yer alacağını, layout dosyasını, textview id'sini ve meyve listemizi parametre olarak gönderiyoruz.
        Adapterı sıfırdan yazmak yerine hazır bir biçimde kullanmak istediğimiz için bu parametreleri gönderdiğimize dikkat edelim.
         Diğer detaylar için: https://gelecegiyazanlar.turkcell.com.tr/konu/android/egitim/android-201/listview-kullanimi */
        ArrayAdapter<String> meyveListAdapter = new ArrayAdapter<String>
                (TodoListActivity.this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1, meyveListesi);

        //Listview'a kullanacağı adapterın, "setAdapter" metodu ile "meyveListeAdapter" olacağını belirtiyoruz.
        lv_meyveler.setAdapter(meyveListAdapter);

        //Alert Dialog nesnesi oluşturuyoruz ve kullanmak istediğimiz özelleriklerini yazıyoruz. PositiveButton, NegativeButton olarak da genişletilebilir.
        final AlertDialog.Builder builder = new AlertDialog.Builder(TodoListActivity.this);
        builder.setTitle("Vitamin İçeriği")
                .setNeutralButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        //Listview içerisinde bir item'a dokunulduğunda yapması gereken işlemleri; "setOnClickListener" interface'ini "Inline Implement" ederek belirliyoruz.
        lv_meyveler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                builder.setMessage("Vitamini boldur");
                builder.show();
            }
        });
    }
}
