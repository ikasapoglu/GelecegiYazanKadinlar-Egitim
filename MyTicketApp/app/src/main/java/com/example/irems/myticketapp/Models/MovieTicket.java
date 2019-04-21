package com.example.irems.myticketapp.Models;

public class MovieTicket {
    private int gorsel;
    private String filmAdi;
    private String filmSeans;
    private String filmFiyat;

    public MovieTicket(){}

    public MovieTicket(int gorsel, String filmAdi, String filmSeans, String filmFiyat) {
        this.gorsel = gorsel;
        this.filmAdi = filmAdi;
        this.filmSeans = filmSeans;
        this.filmFiyat=filmFiyat;
    }

    public int getGorsel() {
        return gorsel;
    }

    public void setGorsel(int gorsel) {
        this.gorsel = gorsel;
    }

    public String getFilmAdi() {
        return filmAdi;
    }

    public void setFilmAdi(String filmAdi) {
        this.filmAdi = filmAdi;
    }

    public String getFilmSeans() {
        return filmSeans;
    }

    public void setFilmSeans(String filmSeans) {
        this.filmSeans = filmSeans;
    }

    public String getFilmFiyat() {
        return filmFiyat;
    }

    public void setFilmFiyat(String filmFiyat) {
        this.filmFiyat = filmFiyat;
    }
}
