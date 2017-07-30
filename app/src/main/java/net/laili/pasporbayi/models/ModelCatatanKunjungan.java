package net.laili.pasporbayi.models;

import android.database.Cursor;

import net.laili.pasporbayi.database.DBHelper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Bend on 7/30/2017.
 */

public class ModelCatatanKunjungan {
    private int index;
    private String tanggal;
    private String umur;
    private String bb;
    private String pb;
    private String lk;
    private String pemeriksaan;
    private String pengobatan;

    public ModelCatatanKunjungan(){}

    public ModelCatatanKunjungan(int index, String tanggal, String umur, String bb, String pb, String lk, String pemeriksaan, String pengobatan) {
        this.index = index;
        this.tanggal = tanggal;
        this.umur = umur;
        this.bb = bb;
        this.pb = pb;
        this.lk = lk;
        this.pemeriksaan = pemeriksaan;
        this.pengobatan = pengobatan;
    }

    public ModelCatatanKunjungan(Cursor cursor){
        this.index = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_INDEX));
        this.tanggal = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CATATAN_KUNJUNGAN_TANGGAL));
        this.umur = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CATATAN_KUNJUNGAN_UMUR));
        this.bb = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CATATAN_KUNJUNGAN_BB));
        this.pb = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CATATAN_KUNJUNGAN_PB));
        this.lk = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CATATAN_KUNJUNGAN_LK));
        this.pemeriksaan = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CATATAN_KUNJUNGAN_PEMERIKSAAN));
        this.pengobatan = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CATATAN_KUNJUNGAN_PENGOBATAN));
    }

    public ModelCatatanKunjungan(JSONObject object) throws JSONException {
        this.index = Integer.valueOf(object.getString(DBHelper.COLUMN_INDEX));
        this.tanggal = object.getString(DBHelper.COLUMN_CATATAN_KUNJUNGAN_TANGGAL);
        this.umur = object.getString(DBHelper.COLUMN_CATATAN_KUNJUNGAN_UMUR);
        this.bb = object.getString(DBHelper.COLUMN_CATATAN_KUNJUNGAN_BB);
        this.pb = object.getString(DBHelper.COLUMN_CATATAN_KUNJUNGAN_PB);
        this.lk = object.getString(DBHelper.COLUMN_CATATAN_KUNJUNGAN_LK);
        this.pemeriksaan = object.getString(DBHelper.COLUMN_CATATAN_KUNJUNGAN_PEMERIKSAAN);
        this.pengobatan = object.getString(DBHelper.COLUMN_CATATAN_KUNJUNGAN_PENGOBATAN);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getPb() {
        return pb;
    }

    public void setPb(String pb) {
        this.pb = pb;
    }

    public String getLk() {
        return lk;
    }

    public void setLk(String lk) {
        this.lk = lk;
    }

    public String getPemeriksaan() {
        return pemeriksaan;
    }

    public void setPemeriksaan(String pemeriksaan) {
        this.pemeriksaan = pemeriksaan;
    }

    public String getPengobatan() {
        return pengobatan;
    }

    public void setPengobatan(String pengobatan) {
        this.pengobatan = pengobatan;
    }

    @Override
    public String toString() {
        return "ModelCatatanKunjungan{" +
                "index=" + index +
                ", tanggal='" + tanggal + '\'' +
                ", umur='" + umur + '\'' +
                ", bb='" + bb + '\'' +
                ", pb='" + pb + '\'' +
                ", lk='" + lk + '\'' +
                ", pemeriksaan='" + pemeriksaan + '\'' +
                ", pengobatan='" + pengobatan + '\'' +
                '}';
    }
}
