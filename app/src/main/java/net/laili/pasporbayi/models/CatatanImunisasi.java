package net.laili.pasporbayi.models;


public class CatatanImunisasi {

private String idImunisasi;
private String tanggal;

/**
* No args constructor for use in serialization
* 
*/
public CatatanImunisasi() {
}

/**
* 
* @param idImunisasi
* @param tanggal
*/
public CatatanImunisasi(String idImunisasi, String tanggal) {
super();
this.idImunisasi = idImunisasi;
this.tanggal = tanggal;
}

public String getIdImunisasi() {
return idImunisasi;
}

public void setIdImunisasi(String idImunisasi) {
this.idImunisasi = idImunisasi;
}

public String getTanggal() {
return tanggal;
}

public void setTanggal(String tanggal) {
this.tanggal = tanggal;
}

}
