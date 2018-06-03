package com.example.asus.firebaseuploadexample.model;

public class Pemesan {

    private String Jenis;
    private String Harga;
    private String Name;
    private String Jumlah;
    private String Nohp;
    private String Daerah;
    private String Coba;



    public Pemesan(){

    }
    public Pemesan (String coba){
        this.Coba = coba;
    }
    public String getCoba() {
        return Coba;
    }

    public void setCoba(String coba) {
        Coba = coba;
    }

    public String getJumlah() {
        return Jumlah;
    }

    public void setJumlah(String jumlah) {
        Jumlah = jumlah;
    }

    public Pemesan(String jenis, String harga, String name, String jumlah, String nohp, String daerah){
        this.Jenis = jenis;
        this.Harga = harga;
        this.Name = name;
        this.Jumlah = jumlah;

        this.Nohp = nohp;
        this.Daerah = daerah;
    }

    public String getJenis() {
        return Jenis;
    }

    public void setJenis(String jenis) {
        Jenis = jenis;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNohp() {
        return Nohp;
    }

    public void setNohp(String nohp) {
        Nohp = nohp;
    }

    public String getDaerah() {
        return Daerah;
    }

    public void setDaerah(String daerah) {
        Daerah = daerah;
    }
}
