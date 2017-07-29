package net.laili.pasporbayi.models;


public class DetailCatatanImunisasi {

private String index;
private String imunisasi;
private String umur;

/**
* No args constructor for use in serialization
* 
*/
public DetailCatatanImunisasi() {
}

/**
* 
* @param index
* @param umur
* @param imunisasi
*/
public DetailCatatanImunisasi(String index, String imunisasi, String umur) {
super();
this.index = index;
this.imunisasi = imunisasi;
this.umur = umur;
}

public String getIndex() {
return index;
}

public void setIndex(String index) {
this.index = index;
}

public String getImunisasi() {
return imunisasi;
}

public void setImunisasi(String imunisasi) {
this.imunisasi = imunisasi;
}

public String getUmur() {
return umur;
}

public void setUmur(String umur) {
this.umur = umur;
}

}
