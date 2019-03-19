package com.gyk.ders4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv_ogrenciler;

    //İçerisine "Ogrenci" tipinden nesne ekleyebileceğimiz bir liste oluşturduk.
    private ArrayList<Ogrenci> ogrenciListesi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_ogrenciler = findViewById(R.id.lv_main_ogrenciler);

        //Ogrenci listesine daha önceki derslerde yaptığımız gibi eleman ekliyoruz.
        //Burada her bir öğrenci için pointer tutmadık. Yani şunu diyebilirdik: "Ogrenci ogr = new Ogrenci(...);"
        // Ancak bize dönen Ogrenci nesnesini sadece listeye ekleyeceğiz dolayısıyla ekleme işleminden başka bir şekilde kullanmayacağız.
        // Bu nedenle direkt olarak "new Ogrenci(..)" şeklinde ekleme işlemini gerçekleştirdik.
        ogrenciListesi.add(new Ogrenci(R.drawable.stone, "Ayşe", "Boğaziçi Üniversitesi"));
        ogrenciListesi.add(new Ogrenci(R.drawable.stthree, "İbrahim", "İstanbul Üniversitesi"));
        ogrenciListesi.add(new Ogrenci(R.drawable.sttwo, "Selma", "Marmara Üniversitesi"));
        ogrenciListesi.add(new Ogrenci(R.drawable.stthree, "Pınar", "Bilgi Üniversitesi"));
        ogrenciListesi.add(new Ogrenci(R.drawable.sttwo, "Aslı", "Haliç Üniversitesi"));

        //Önceki derslerde yaptığımız gibi, Listview'in veri modeli ile çalışabilmesi için bir adapter nesnesi tanımlıyoruz.
        //Ancak hazır adapter işimizi görmeyeceğinden kendi ihtiyaçlarımıza göre bir "CustomAdapter" sınıfı oluşturduk.
        //CustomAdapter'ın "BaseAdapter" classından türeyip onun özelliklerini kullanabildiğine dikkat edelim.
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, ogrenciListesi);
        lv_ogrenciler.setAdapter(customAdapter);
    }
}
