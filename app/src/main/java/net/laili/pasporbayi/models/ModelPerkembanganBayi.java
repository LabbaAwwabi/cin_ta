package net.laili.pasporbayi.models;


import android.database.Cursor;

import net.laili.pasporbayi.database.DBHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class ModelPerkembanganBayi {
    private int index;
    private String umur;
    private String tipe;
    private String detail;
    private int status;

    public ModelPerkembanganBayi(){}

    public ModelPerkembanganBayi(int index, String umur, String tipe, String detail, int status) {
        this.index = index;
        this.umur = umur;
        this.tipe = tipe;
        this.detail = detail;
        this.status = status;
    }

    public ModelPerkembanganBayi(Cursor cursor){
        this.index = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_INDEX));
        this.umur = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PERKEMBANGAN_BAYI_UMUR));
        this.tipe = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PERKEMBANGAN_BAYI_TIPE));
        this.detail = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PERKEMBANGAN_BAYI_DETAIL));
        this.status = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_PERKEMBANGAN_BAYI_STATUS));
    }

    public ModelPerkembanganBayi(JSONObject object) throws JSONException {
        this.index = Integer.valueOf(object.getString(DBHelper.COLUMN_INDEX));

        if(object.has(DBHelper.COLUMN_PERKEMBANGAN_BAYI_STATUS)){
            this.status = Integer.valueOf(object.getString(DBHelper.COLUMN_PERKEMBANGAN_BAYI_STATUS));
        }else{
            this.umur = object.getString(DBHelper.COLUMN_PERKEMBANGAN_BAYI_UMUR);
            this.tipe = object.getString(DBHelper.COLUMN_PERKEMBANGAN_BAYI_TIPE);
            this.detail = object.getString(DBHelper.COLUMN_PERKEMBANGAN_BAYI_DETAIL);
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
