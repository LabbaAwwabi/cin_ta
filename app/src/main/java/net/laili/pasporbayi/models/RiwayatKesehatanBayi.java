package net.laili.pasporbayi.models;


public class RiwayatKesehatanBayi {

private String kesehatanBayiSaatLahir;
private String kesehatanBayiSelamaDiRuangBayi;
private String imunisasiYangTelahDiberikan;
private String pengobatanYangTelahDiberikan;
private String pemeriksaanLain;

/**
* No args constructor for use in serialization
* 
*/
public RiwayatKesehatanBayi() {
}

/**
* 
* @param pemeriksaanLain
* @param kesehatanBayiSaatLahir
* @param imunisasiYangTelahDiberikan
* @param pengobatanYangTelahDiberikan
* @param kesehatanBayiSelamaDiRuangBayi
*/
public RiwayatKesehatanBayi(String kesehatanBayiSaatLahir, String kesehatanBayiSelamaDiRuangBayi, String imunisasiYangTelahDiberikan, String pengobatanYangTelahDiberikan, String pemeriksaanLain) {
super();
this.kesehatanBayiSaatLahir = kesehatanBayiSaatLahir;
this.kesehatanBayiSelamaDiRuangBayi = kesehatanBayiSelamaDiRuangBayi;
this.imunisasiYangTelahDiberikan = imunisasiYangTelahDiberikan;
this.pengobatanYangTelahDiberikan = pengobatanYangTelahDiberikan;
this.pemeriksaanLain = pemeriksaanLain;
}

public String getKesehatanBayiSaatLahir() {
return kesehatanBayiSaatLahir;
}

public void setKesehatanBayiSaatLahir(String kesehatanBayiSaatLahir) {
this.kesehatanBayiSaatLahir = kesehatanBayiSaatLahir;
}

public String getKesehatanBayiSelamaDiRuangBayi() {
return kesehatanBayiSelamaDiRuangBayi;
}

public void setKesehatanBayiSelamaDiRuangBayi(String kesehatanBayiSelamaDiRuangBayi) {
this.kesehatanBayiSelamaDiRuangBayi = kesehatanBayiSelamaDiRuangBayi;
}

public String getImunisasiYangTelahDiberikan() {
return imunisasiYangTelahDiberikan;
}

public void setImunisasiYangTelahDiberikan(String imunisasiYangTelahDiberikan) {
this.imunisasiYangTelahDiberikan = imunisasiYangTelahDiberikan;
}

public String getPengobatanYangTelahDiberikan() {
return pengobatanYangTelahDiberikan;
}

public void setPengobatanYangTelahDiberikan(String pengobatanYangTelahDiberikan) {
this.pengobatanYangTelahDiberikan = pengobatanYangTelahDiberikan;
}

public String getPemeriksaanLain() {
return pemeriksaanLain;
}

public void setPemeriksaanLain(String pemeriksaanLain) {
this.pemeriksaanLain = pemeriksaanLain;
}

}
