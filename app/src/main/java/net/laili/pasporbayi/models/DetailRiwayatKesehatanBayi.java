package net.laili.pasporbayi.models;


public class DetailRiwayatKesehatanBayi {

private String index;
private String kolom;

/**
* No args constructor for use in serialization
* 
*/
public DetailRiwayatKesehatanBayi() {
}

/**
* 
* @param index
* @param kolom
*/
public DetailRiwayatKesehatanBayi(String index, String kolom) {
super();
this.index = index;
this.kolom = kolom;
}

public String getIndex() {
return index;
}

public void setIndex(String index) {
this.index = index;
}

public String getKolom() {
return kolom;
}

public void setKolom(String kolom) {
this.kolom = kolom;
}

}
