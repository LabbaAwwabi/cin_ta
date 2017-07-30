package net.laili.pasporbayi.models;


import android.database.Cursor;

import net.laili.pasporbayi.DBHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class RiwayatKelahiran {

    private String tanggalLahir;
    private String namaRumahSakit;
    private String penolongPersalinan;
    private String umurKelahiran;
    private String letakJanin;
    private String caraLahir;
    private String apgarScope;
    private String beratBadanLahir;
    private String panjangBadanLahir;
    private String lingkarKepala;
    private String lingkarDada;
    private String taliPusat;
    private String airKetuban;
    private String beratPlacenta;
    private String golonganDarah;

    public RiwayatKelahiran() {}

    public RiwayatKelahiran(String tanggalLahir, String namaRumahSakit, String penolongPersalinan, String umurKelahiran, String letakJanin, String caraLahir, String apgarScope, String beratBadanLahir, String panjangBadanLahir, String lingkarKepala, String lingkarDada, String taliPusat, String airKetuban, String beratPlacenta, String golonganDarah) {
        this.tanggalLahir = tanggalLahir;
        this.namaRumahSakit = namaRumahSakit;
        this.penolongPersalinan = penolongPersalinan;
        this.umurKelahiran = umurKelahiran;
        this.letakJanin = letakJanin;
        this.caraLahir = caraLahir;
        this.apgarScope = apgarScope;
        this.beratBadanLahir = beratBadanLahir;
        this.panjangBadanLahir = panjangBadanLahir;
        this.lingkarKepala = lingkarKepala;
        this.lingkarDada = lingkarDada;
        this.taliPusat = taliPusat;
        this.airKetuban = airKetuban;
        this.beratPlacenta = beratPlacenta;
        this.golonganDarah = golonganDarah;
    }

    public RiwayatKelahiran(Cursor cursor){
        this.tanggalLahir = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_TANGGAL_LAHIR));
        this.namaRumahSakit = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_NAMA_RUMAH_SAKIT));
        this.penolongPersalinan = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_PENOLONG_PERSALINAN));
        this.umurKelahiran = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_UMUR_KELAHIRAN));
        this.letakJanin = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_LETAK_JANIN));
        this.caraLahir = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_CARA_LAHIR));
        this.apgarScope = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_APGAR_SCOPE));
        this.beratBadanLahir = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_BERAT_BADAN_LAHIR));
        this.panjangBadanLahir = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_PANJANG_BADAN_LAHIR));
        this.lingkarKepala = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_LINGKAR_KEPALA));
        this.lingkarDada = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_LINGKAR_DADA));
        this.taliPusat = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_TALI_PUSAT));
        this.airKetuban = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_AIR_KETUBAN));
        this.beratPlacenta = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_BERAT_PLACENTA));
        this.golonganDarah = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_GOLONGAN_DARAH));
    }

    public RiwayatKelahiran(JSONObject object) throws JSONException {
        this.tanggalLahir = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_TANGGAL_LAHIR);
        this.namaRumahSakit = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_NAMA_RUMAH_SAKIT);
        this.penolongPersalinan = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_PENOLONG_PERSALINAN);
        this.umurKelahiran = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_UMUR_KELAHIRAN);
        this.letakJanin = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_LETAK_JANIN);
        this.caraLahir = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_CARA_LAHIR);
        this.apgarScope = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_APGAR_SCOPE);
        this.beratBadanLahir = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_BERAT_BADAN_LAHIR);
        this.panjangBadanLahir = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_PANJANG_BADAN_LAHIR);
        this.lingkarKepala = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_LINGKAR_KEPALA);
        this.lingkarDada = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_LINGKAR_DADA);
        this.taliPusat = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_TALI_PUSAT);
        this.airKetuban = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_AIR_KETUBAN);
        this.beratPlacenta = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_BERAT_PLACENTA);
        this.golonganDarah = object.getString(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_GOLONGAN_DARAH);
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getNamaRumahSakit() {
        return namaRumahSakit;
    }

    public void setNamaRumahSakit(String namaRumahSakit) {
        this.namaRumahSakit = namaRumahSakit;
    }

    public String getPenolongPersalinan() {
        return penolongPersalinan;
    }

    public void setPenolongPersalinan(String penolongPersalinan) {
        this.penolongPersalinan = penolongPersalinan;
    }

    public String getUmurKelahiran() {
        return umurKelahiran;
    }

    public void setUmurKelahiran(String umurKelahiran) {
        this.umurKelahiran = umurKelahiran;
    }

    public String getLetakJanin() {
        return letakJanin;
    }

    public void setLetakJanin(String letakJanin) {
        this.letakJanin = letakJanin;
    }

    public String getCaraLahir() {
        return caraLahir;
    }

    public void setCaraLahir(String caraLahir) {
        this.caraLahir = caraLahir;
    }

    public String getApgarScope() {
        return apgarScope;
    }

    public void setApgarScope(String apgarScope) {
        this.apgarScope = apgarScope;
    }

    public String getBeratBadanLahir() {
        return beratBadanLahir;
    }

    public void setBeratBadanLahir(String beratBadanLahir) {
        this.beratBadanLahir = beratBadanLahir;
    }

    public String getPanjangBadanLahir() {
        return panjangBadanLahir;
    }

    public void setPanjangBadanLahir(String panjangBadanLahir) {
        this.panjangBadanLahir = panjangBadanLahir;
    }

    public String getLingkarKepala() {
        return lingkarKepala;
    }

    public void setLingkarKepala(String lingkarKepala) {
        this.lingkarKepala = lingkarKepala;
    }

    public String getLingkarDada() {
        return lingkarDada;
    }

    public void setLingkarDada(String lingkarDada) {
        this.lingkarDada = lingkarDada;
    }

    public String getTaliPusat() {
        return taliPusat;
    }

    public void setTaliPusat(String taliPusat) {
        this.taliPusat = taliPusat;
    }

    public String getAirKetuban() {
        return airKetuban;
    }

    public void setAirKetuban(String airKetuban) {
        this.airKetuban = airKetuban;
    }

    public String getBeratPlacenta() {
        return beratPlacenta;
    }

    public void setBeratPlacenta(String beratPlacenta) {
        this.beratPlacenta = beratPlacenta;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }
}
