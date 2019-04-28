package com.example.irems.myticketapp.Models;

public class MovieTicket {
    private String gorsel;
    private String filmAdi;
    private String filmSeans;
    private String filmFiyat;

    public MovieTicket() {
    }

    public MovieTicket(String gorsel, String filmAdi, String filmSeans, String filmFiyat) {
        this.gorsel = gorsel;
        this.filmAdi = filmAdi;
        this.filmSeans = filmSeans;
        this.filmFiyat = filmFiyat;
    }

    public String getGorsel() {
        return gorsel;
    }

    public void setGorsel(String gorsel) {
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
