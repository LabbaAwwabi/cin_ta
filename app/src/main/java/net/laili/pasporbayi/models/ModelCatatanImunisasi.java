package net.laili.pasporbayi.models;


import android.database.Cursor;

import net.laili.pasporbayi.database.DBHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class ModelCatatanImunisasi {
    private int index;
    private String imunisasi;
    private String umur;
    private String tanggal;

    public ModelCatatanImunisasi(){}

    public ModelCatatanImunisasi(int index, String imunisasi, String umur, String tanggal) {
        this.index = index;
        this.imunisasi = imunisasi;
        this.umur = umur;
        this.tanggal = tanggal;
    }

    public ModelCatatanImunisasi(Cursor cursor){
        this.index = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_INDEX));
        this.imunisasi = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CATATAN_IMUNISASI_IMUNISASI));
        this.umur = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CATATAN_IMUNISASI_UMUR));
        this.tanggal = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CATATAN_IMUNISASI_TANGGAL));
    }

    public ModelCatatanImunisasi(JSONObject object) throws JSONException {
        this.index = Integer.valueOf(object.getString(DBHelper.COLUMN_INDEX));

        if(object.has(DBHelper.COLUMN_CATATAN_IMUNISASI_TANGGAL)){
            this.tanggal = object.getString(DBHelper.COLUMN_CATATAN_IMUNISASI_TANGGAL);
        }else{
            this.imunisasi = object.getString(DBHelper.COLUMN_CATATAN_IMUNISASI_IMUNISASI);
            this.umur = object.getString(DBHelper.COLUMN_CATATAN_IMUNISASI_UMUR);
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
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

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
