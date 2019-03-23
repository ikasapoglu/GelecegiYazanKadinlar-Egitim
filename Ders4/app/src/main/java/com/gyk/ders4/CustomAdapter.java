package com.gyk.ders4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Ogrenci> ogrenciListe;

    //Constructor tanımlayarak CustomAdapter'ın belleğe çıkarken dışarıdan aldığımız context ve ogrenciListesi ile oluşturulmasını sağlıyoruz.
    //MainActivity 36. satırda CustomAdapter sınıfından nasıl örnek aldığımıza ve hangi parametreleri içerisine gönderdiğimize bakın.
    public CustomAdapter(Context _context, ArrayList<Ogrenci> _ogrenciListe) {
        this.context = _context;
        this.ogrenciListe = _ogrenciListe;
    }

    //getCount metodu BaseAdapter sınıfından gelen kullanılması zorunlu bir özellik.
    //Kısaca adapterın ekrana basması gereken listenin kaç elamana sahip olduğunu döndürüyoruz.
    //Bu sayede sınıf belleğe çıktığında getCount metodunu çalıştırıp listenin kaç elemanlı olduğunu öğreniyor ve ona göre item oluşturmaya/çekmeye çalışıyor
    @Override
    public int getCount() {
        //Bu satırı "return 2;" şeklinde değiştirerek neler olacağını gözlemleyelim;
        return ogrenciListe.size();
    }


    //"BaseAdapter" tarafından yazılması zorunlu kılınan bir metod
    //Metodu çağırdığımızda pozisyona ait olan elemanı döndürmekte
    @Override
    public Object getItem(int position) {
        return ogrenciListe.get(position);
    }

    //"BaseAdapter" tarafından yazılması zorunlu kılınan bir metod
    //Metodu çağırdığımızda pozisyona ait olan elemanın id'sini döndürmekte. Ogrenci sınıfında bir id tutmadığımızdan şimdilik pozisyon (index) değeri ne ise onu döndürüyoruz.
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Yine "BaseAdapter" tarafından kullanmamız zorunlu olan bir metod. Adapter liste itemlarını ekrana bir bir basarken buraya bir pozisyon bilgisi yollamakta.
    // Kısaca şöyle bir senaryo dönüyor: Ben x pozisyonundaki itemı ekrana basacağım, bu bana verdiğin listedeki hangi elemana denk geliyor ?
    // Ve biz de hangi pozisyondaki itemı basıyorsan öğrenciListesinden de o pozisyona(index'e) denk gelen itemı basacaksın demiş oluyoruz
    // "position" değerini 55. satırda "position = 0;" diyerek sonuclarını gözlemleyelim. (veya 61-63 satırlarda "ogrenciListe.get(0);")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View v = convertView.inflate(context, R.layout.listitem_ogrenci, null);

        ImageView iv_profil = v.findViewById(R.id.iv_profil);
        TextView tv_isim = v.findViewById(R.id.tv_ogrencisim);
        TextView tv_okulismi = v.findViewById(R.id.tv_okuladi);


        iv_profil.setImageResource(ogrenciListe.get(position).resimUrl);
        tv_isim.setText(ogrenciListe.get(position).isim);
        tv_okulismi.setText(ogrenciListe.get(position).okulismi);

        return v;
    }
}
