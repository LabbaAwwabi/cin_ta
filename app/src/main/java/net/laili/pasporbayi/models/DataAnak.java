package net.laili.pasporbayi.models;


public class DataAnak {

private String nama;
private String tanggalLahir;
private String waktu;
private String berat;
private String panjang;
private String lingkarKepala;
private String tempatLahir;
private String rumahSakit;
private String namaAyah;
private String tempatTanggalLahirAyah;
private String pekerjaanAyah;
private String alamatKantorAyah;
private String teleponKantorAyah;
private String teleponSelulerAyah;
private String namaIbu;
private String tempatTanggalLahirIbu;
private String pekerjaanIbu;
private String alamatKantorIbu;
private String teleponKantorIbu;
private String teleponSelulerIbu;
private String namaDokterKandungan;
private String namaDokterAnak;
private String kondisiAtauSaranKhusus;

/**
* No args constructor for use in serialization
* 
*/
public DataAnak() {
}

/**
* 
* @param berat
* @param alamatKantorIbu
* @param tempatLahir
* @param teleponSelulerIbu
* @param tempatTanggalLahirAyah
* @param tanggalLahir
* @param namaAyah
* @param kondisiAtauSaranKhusus
* @param namaIbu
* @param waktu
* @param namaDokterAnak
* @param teleponKantorAyah
* @param alamatKantorAyah
* @param pekerjaanAyah
* @param namaDokterKandungan
* @param teleponKantorIbu
* @param pekerjaanIbu
* @param tempatTanggalLahirIbu
* @param nama
* @param teleponSelulerAyah
* @param rumahSakit
* @param panjang
* @param lingkarKepala
*/
public DataAnak(String nama, String tanggalLahir, String waktu, String berat, String panjang, String lingkarKepala, String tempatLahir, String rumahSakit, String namaAyah, String tempatTanggalLahirAyah, String pekerjaanAyah, String alamatKantorAyah, String teleponKantorAyah, String teleponSelulerAyah, String namaIbu, String tempatTanggalLahirIbu, String pekerjaanIbu, String alamatKantorIbu, String teleponKantorIbu, String teleponSelulerIbu, String namaDokterKandungan, String namaDokterAnak, String kondisiAtauSaranKhusus) {
super();
this.nama = nama;
this.tanggalLahir = tanggalLahir;
this.waktu = waktu;
this.berat = berat;
this.panjang = panjang;
this.lingkarKepala = lingkarKepala;
this.tempatLahir = tempatLahir;
this.rumahSakit = rumahSakit;
this.namaAyah = namaAyah;
this.tempatTanggalLahirAyah = tempatTanggalLahirAyah;
this.pekerjaanAyah = pekerjaanAyah;
this.alamatKantorAyah = alamatKantorAyah;
this.teleponKantorAyah = teleponKantorAyah;
this.teleponSelulerAyah = teleponSelulerAyah;
this.namaIbu = namaIbu;
this.tempatTanggalLahirIbu = tempatTanggalLahirIbu;
this.pekerjaanIbu = pekerjaanIbu;
this.alamatKantorIbu = alamatKantorIbu;
this.teleponKantorIbu = teleponKantorIbu;
this.teleponSelulerIbu = teleponSelulerIbu;
this.namaDokterKandungan = namaDokterKandungan;
this.namaDokterAnak = namaDokterAnak;
this.kondisiAtauSaranKhusus = kondisiAtauSaranKhusus;
}

public String getNama() {
return nama;
}

public void setNama(String nama) {
this.nama = nama;
}

public String getTanggalLahir() {
return tanggalLahir;
}

public void setTanggalLahir(String tanggalLahir) {
this.tanggalLahir = tanggalLahir;
}

public String getWaktu() {
return waktu;
}

public void setWaktu(String waktu) {
this.waktu = waktu;
}

public String getBerat() {
return berat;
}

public void setBerat(String berat) {
this.berat = berat;
}

public String getPanjang() {
return panjang;
}

public void setPanjang(String panjang) {
this.panjang = panjang;
}

public String getLingkarKepala() {
return lingkarKepala;
}

public void setLingkarKepala(String lingkarKepala) {
this.lingkarKepala = lingkarKepala;
}

public String getTempatLahir() {
return tempatLahir;
}

public void setTempatLahir(String tempatLahir) {
this.tempatLahir = tempatLahir;
}

public String getRumahSakit() {
return rumahSakit;
}

public void setRumahSakit(String rumahSakit) {
this.rumahSakit = rumahSakit;
}

public String getNamaAyah() {
return namaAyah;
}

public void setNamaAyah(String namaAyah) {
this.namaAyah = namaAyah;
}

public String getTempatTanggalLahirAyah() {
return tempatTanggalLahirAyah;
}

public void setTempatTanggalLahirAyah(String tempatTanggalLahirAyah) {
this.tempatTanggalLahirAyah = tempatTanggalLahirAyah;
}

public String getPekerjaanAyah() {
return pekerjaanAyah;
}

public void setPekerjaanAyah(String pekerjaanAyah) {
this.pekerjaanAyah = pekerjaanAyah;
}

public String getAlamatKantorAyah() {
return alamatKantorAyah;
}

public void setAlamatKantorAyah(String alamatKantorAyah) {
this.alamatKantorAyah = alamatKantorAyah;
}

public String getTeleponKantorAyah() {
return teleponKantorAyah;
}

public void setTeleponKantorAyah(String teleponKantorAyah) {
this.teleponKantorAyah = teleponKantorAyah;
}

public String getTeleponSelulerAyah() {
return teleponSelulerAyah;
}

public void setTeleponSelulerAyah(String teleponSelulerAyah) {
this.teleponSelulerAyah = teleponSelulerAyah;
}

public String getNamaIbu() {
return namaIbu;
}

public void setNamaIbu(String namaIbu) {
this.namaIbu = namaIbu;
}

public String getTempatTanggalLahirIbu() {
return tempatTanggalLahirIbu;
}

public void setTempatTanggalLahirIbu(String tempatTanggalLahirIbu) {
this.tempatTanggalLahirIbu = tempatTanggalLahirIbu;
}

public String getPekerjaanIbu() {
return pekerjaanIbu;
}

public void setPekerjaanIbu(String pekerjaanIbu) {
this.pekerjaanIbu = pekerjaanIbu;
}

public String getAlamatKantorIbu() {
return alamatKantorIbu;
}

public void setAlamatKantorIbu(String alamatKantorIbu) {
this.alamatKantorIbu = alamatKantorIbu;
}

public String getTeleponKantorIbu() {
return teleponKantorIbu;
}

public void setTeleponKantorIbu(String teleponKantorIbu) {
this.teleponKantorIbu = teleponKantorIbu;
}

public String getTeleponSelulerIbu() {
return teleponSelulerIbu;
}

public void setTeleponSelulerIbu(String teleponSelulerIbu) {
this.teleponSelulerIbu = teleponSelulerIbu;
}

public String getNamaDokterKandungan() {
return namaDokterKandungan;
}

public void setNamaDokterKandungan(String namaDokterKandungan) {
this.namaDokterKandungan = namaDokterKandungan;
}

public String getNamaDokterAnak() {
return namaDokterAnak;
}

public void setNamaDokterAnak(String namaDokterAnak) {
this.namaDokterAnak = namaDokterAnak;
}

public String getKondisiAtauSaranKhusus() {
return kondisiAtauSaranKhusus;
}

public void setKondisiAtauSaranKhusus(String kondisiAtauSaranKhusus) {
this.kondisiAtauSaranKhusus = kondisiAtauSaranKhusus;
}

}
