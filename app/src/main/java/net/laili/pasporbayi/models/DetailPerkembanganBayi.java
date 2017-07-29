package net.laili.pasporbayi.models;


public class DetailPerkembanganBayi {

private String index;
private String umur;
private String tipe;
private String detail;

/**
* No args constructor for use in serialization
* 
*/
public DetailPerkembanganBayi() {
}

/**
* 
* @param detail
* @param index
* @param umur
* @param tipe
*/
public DetailPerkembanganBayi(String index, String umur, String tipe, String detail) {
super();
this.index = index;
this.umur = umur;
this.tipe = tipe;
this.detail = detail;
}

public String getIndex() {
return index;
}

public void setIndex(String index) {
this.index = index;
}

public String getUmur() {
return umur;
}

public void setUmur(String umur) {
this.umur = umur;
}

public String getTipe() {
return tipe;
}

public void setTipe(String tipe) {
this.tipe = tipe;
}

public String getDetail() {
return detail;
}

public void setDetail(String detail) {
this.detail = detail;
}

}
