package com.gyk.ders4;

//Ogrenci sınıfı bir öğrencinin bilgilerini tutmaktan sorumlu.
public class Ogrenci {

    int resimUrl;
    String isim;
    String okulismi;

    //Bir constructor tanımladık.
    //Ogrenci sınıfı belleğe çıkarken, dışarıdan alınan bu parametreleri de içerisindeki fieldlar ile eşleştirmekte.
    //Bu sayede öğrenciye ait bilgileri RAM'de "Ogrenci" adi altında depoluyoruz.
    //Buradaki "this" keywordu sınıfa ait olan değişkeni kullandığımızı ifade etmekte.
    // resimURL'i int tipinde tutmamızın sebebi gerçek bir veritabanı veya web servis ile çalışmadığımızdan kaynaklı. Drawable klasörüne attığımız her image otomatik olarak bir id alır ve id int tipinde tutulur.
    // Yani aslında "R.drawable.stone" yazdığımızda bu "700094" değerini tutan bir integer değişkenini ifade etmektedir. Tıpkı şunun gibi: "int sonuc = 5; print(sonuc); "
    //MainActivity 27-31. satırlarında Ogrenci sınıfını nasıl istediğimize ve hangi parametreleri içerisine gönderdiğimize bakın. Ayrıca R.drawable.* yazan kısımda drawable nesnelerinin id'lerine mouse ile üzerine gelerek görebilirsiniz. (örn. stone)
    public Ogrenci(int _resimUrl, String _isim, String _okulismi){
        this.resimUrl = _resimUrl;
        this.isim = _isim;
        this.okulismi = _okulismi;
    }
}
