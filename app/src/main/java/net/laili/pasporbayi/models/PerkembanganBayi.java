package net.laili.pasporbayi.models;


public class PerkembanganBayi {

private String idPerkembangan;
private Boolean selesai;

/**
* No args constructor for use in serialization
* 
*/
public PerkembanganBayi() {
}

/**
* 
* @param selesai
* @param idPerkembangan
*/
public PerkembanganBayi(String idPerkembangan, Boolean selesai) {
super();
this.idPerkembangan = idPerkembangan;
this.selesai = selesai;
}

public String getIdPerkembangan() {
return idPerkembangan;
}

public void setIdPerkembangan(String idPerkembangan) {
this.idPerkembangan = idPerkembangan;
}

public Boolean getSelesai() {
return selesai;
}

public void setSelesai(Boolean selesai) {
this.selesai = selesai;
}

}
