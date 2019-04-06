package com.gyk.ders6.models;

public class DiyetOgun {

  private int gorsel;
  private String besinIcerik;
  private String kaloriDegeri;

  //WARNING: These variables will be ENCAPSULATED!

    public DiyetOgun(int gorsel, String besinIcerik, String kaloriDegeri) {
        this.gorsel = gorsel;
        this.besinIcerik = besinIcerik;
        this.kaloriDegeri = kaloriDegeri;
    }

    public int getGorsel() {
        return gorsel;
    }

    public void setGorsel(int gorsel) {
        this.gorsel = gorsel;
    }

    public String getBesinIcerik() {
        return besinIcerik;
    }

    public void setBesinIcerik(String besinIcerik) {
        this.besinIcerik = besinIcerik;
    }

    public String getKaloriDegeri() {
        return kaloriDegeri;
    }

    public void setKaloriDegeri(String kaloriDegeri) {
        this.kaloriDegeri = kaloriDegeri;
    }
}
