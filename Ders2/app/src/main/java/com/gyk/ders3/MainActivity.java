package com.gyk.ders3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Detaylı anlatım için Listview kullanımı makalesini okuyabilirsiniz. https://gelecegiyazanlar.turkcell.com.tr/konu/android/egitim/android-201/listview-kullanimi

    //Tasarım ekranındaki (activity_main.xml) öğeleri içeride kullanabilmek için tanımlamalarını yapıyoruz.
    //Daha sonra findviewbyid metodu ile UI ekranındaki karşılıklarını atayacağız. Yani bu değişken UI'da şu öğeyi temsil etmekte demiş olacağız.
    private TextView tv_toplanan, tv_toplayan, tv_sonuc;
    private SeekBar sbar_toplayan, sbar_toplanan;
    private Button btn_hesapla;
    private ListView lv_gecmis;

    //Matematiksel işlem yapacağımızdan int değerleri tanımlıyoruz. Daha sonra bu değerlere seekbar öğesinden aldığımız "progress"leri yani seekbarın güncel değerini atacağız.
    private int toplananDeger, toplayanDeger, sonucDeger;

    //Geçmiş listesini daha sonra içerisine item yüklemek üzere oluşturuyoruz.  <String> ifadesi içerisine gelecek olan datanın (yani her bir item'ın) String olacağını bildirmekte
    ArrayList<String> gecmisListesi = new ArrayList<>();


    //Bir adapter nesnesi tanımlıyoruz. <String> ifadesi içerisine gelecek olan datanın (yani her bir item'ın) String olacağını bildirmekte. Daha sonra AdapteriYukle() metodu içerisinde (117. Satır) ArrayAdapter sınıfından bir örnek alarak bu değişkene atayacağız.
    //Şu anda herhangi bir atama yapmadığımızdan gecmisListeAdapter değişkeninin ram bellekteki durumu "null" olacaktır.
    //Dolayısıyla AdapteriYukle() metodunu çalıştırmadan bu değişken üzerinde bir işlem yapmaya çalışacak olursak ".. on a null object reference exception" hatası alacağız.
    //AdapteriYukle() metodunu çağırdığımız satırı (99. Satır) yorum satırına dönüştürerek hatayı gözlemleyebiliriz.
    ArrayAdapter<String> gecmisListeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Bu activity bu tasarım dosyasını (activity_main) kullanacak, onu yükle.
        setContentView(R.layout.activity_main);

        //Bu compenentlar UI'da hangi öğeyi temsil ediyor? Onları belirtiyoruz.
        tv_toplanan = findViewById(R.id.tv_main_toplanan);
        tv_toplayan = findViewById(R.id.tv_main_toplayan);
        tv_sonuc = findViewById(R.id.tv_main_sonuc);

        sbar_toplanan = findViewById(R.id.sbar_main_toplanan);
        sbar_toplayan = findViewById(R.id.sbar_main_toplayan);

        btn_hesapla = findViewById(R.id.btn_main_hesapla);

        lv_gecmis = findViewById(R.id.lv_main_gecmishesaplamalar);

        //Seekbar'ın OnSeekBarChangeListener özelliğini implement ediyoruz.
        //Bu sayede seekbar'ı her hareket ettirdiğimizde onProgressChanged metodu otomatik olarak çağırılıyor ve parametre olarak gelen "progress" değişkeninden seekbar'ın o anki değerini alabiliyoruz. Tıpkı butonların onclick metodları gibi.
        //Diğer detaylar için resmi sitede bulunan Seekbar dökümanını inceleyebilirsiniz. https://developer.android.com/reference/android/widget/SeekBar
        sbar_toplanan.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //toplananDeger değişkenini matematiksel işlem yapmak için int tipinde tanımlamıştık. "progress" parametresi int olarak geldiğinden direkt olarak içine atayabiliriz.
                toplananDeger = progress;

                //Textview.setText() metodu aynı layout dosyasında olduğu gibi bir text almakta. Ancak seekbar'ın güncel değeri tamsayı olarak geldiğinden (ki biz bu projede 0-500 arası olarak ayarladık)
                //progress değeri int olarak gelmekte. int değerini String'e dönüştürmek için String.valueOf() metodunu kullanıyoruz. Bu metod int değer alarak String nesnesine çevirerek geri döndürüyor.
                tv_toplanan.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sbar_toplayan.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                toplayanDeger = progress;
                tv_toplayan.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn_hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Basit bir toplama işlemi..
                sonucDeger = toplananDeger + toplayanDeger;
                tv_sonuc.setText(String.valueOf(sonucDeger));

                //Kendi oluşturduğumuz AdapteraItemEkle metodunu çağırıyoruz. Metodlar aynı kodu tekrar tekrar yazmamızı önlemekte. Bu sayede metodu istediğimiz yerde çağırabilir ve adaptera yeni item ekleyebiliriz.
                AdapteraItemEkle(String.valueOf(toplananDeger), String.valueOf(toplayanDeger), String.valueOf(sonucDeger));
            }
        });

        //AdapteriYukle() metodunu çağırarak, içinde bulunduğumuz OnCreate Metodunu gereksiz kod kalabalığından kurtarmış oluyoruz. Bu sayede daha okunabilir kod elde ettiğimize dikkat edelim.
        AdapteriYukle();
        //UI'da bulunan Listview öğemizin "gecmisListeAdapter" ile çalışacağını belirtiyoruz.
        lv_gecmis.setAdapter(gecmisListeAdapter);

    }

    private void AdapteraItemEkle(String toplanan, String toplayan, String sonuc) {
        //Listeye bu metoda gelen parametreleri kullanarak yeni bir eleman ekliyoruz.
        /* Bu kod şu şekilde de olabilirdi:
         * String eklenecekYazi = toplanan + " + " + toplayan + " sonucu: " + sonuc;
         * gecmisListesi.add(eklenecekYazi);
         */
        gecmisListesi.add(toplanan + " + " + toplayan + " sonucu: " + sonuc);
        //Adapter'ı listeye yeni bir eleman eklendiğinden haberdar ediyoruz.
        //Bu sayede adapter "gecmisListesi" nesnesindeki dataları tekrar çekerek tasarım ekranında bulunan ListView öğesini güncelliyor. Bu satırı eklemezsek adapter yapılan değişikliklerden haberdar olmayacak ve ekranı güncellemeyecektir.
        gecmisListeAdapter.notifyDataSetChanged();
    }

    private void AdapteriYukle() {
        /*Adapterı "new" keywordu ile oluşturuyoruz. Parametre olarak:
         * context,
         * item görünümü için layout,
         * layout dosyasının içindeki texti güncellemek için, içerisinde bulunan textview'ın idsi,
         * ve son olarak hangi data ile çalışacağı bilgisini gönderiyoruz.*/
        gecmisListeAdapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                gecmisListesi);
    }
}
