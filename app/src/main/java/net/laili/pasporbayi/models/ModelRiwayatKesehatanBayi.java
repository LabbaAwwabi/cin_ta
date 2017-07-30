package net.laili.pasporbayi.models;


import android.database.Cursor;

import net.laili.pasporbayi.database.DBHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class ModelRiwayatKesehatanBayi {
    private int index;
    private String kesehatanBayiSaatLahir;
    private String kesehatanBayiSelamaDiRuangBayi;
    private String imunisasiYangTelahDiberikan;
    private String pengobatanYangTelahDiberikan;
    private String pemeriksaanLain;

    public ModelRiwayatKesehatanBayi(){}

    public ModelRiwayatKesehatanBayi(int index, String kesehatanBayiSaatLahir, String kesehatanBayiSelamaDiRuangBayi, String imunisasiYangTelahDiberikan, String pengobatanYangTelahDiberikan, String pemeriksaanLain) {
        this.index = index;
        this.kesehatanBayiSaatLahir = kesehatanBayiSaatLahir;
        this.kesehatanBayiSelamaDiRuangBayi = kesehatanBayiSelamaDiRuangBayi;
        this.imunisasiYangTelahDiberikan = imunisasiYangTelahDiberikan;
        this.pengobatanYangTelahDiberikan = pengobatanYangTelahDiberikan;
        this.pemeriksaanLain = pemeriksaanLain;
    }

    public ModelRiwayatKesehatanBayi(Cursor cursor){
        this.index = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_INDEX));
        this.kesehatanBayiSaatLahir = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_KESEHATAN_BAYI_SAAT_LAHIR));
        this.kesehatanBayiSelamaDiRuangBayi = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_KESEHATAN_BAYI_SELAMA_DI_RUANG_BAYI));
        this.imunisasiYangTelahDiberikan = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_IMUNISASI_YANG_TELAH_DIBERIKAN));
        this.pengobatanYangTelahDiberikan = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_PENGOBATAN_YANG_TELAH_DIBERIKAN));
        this.pemeriksaanLain = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_PEMERIKSAAN_LAIN));
    }

    public ModelRiwayatKesehatanBayi(JSONObject object) throws JSONException {
        this.kesehatanBayiSaatLahir = object.getString(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_KESEHATAN_BAYI_SAAT_LAHIR);
        this.kesehatanBayiSelamaDiRuangBayi = object.getString(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_KESEHATAN_BAYI_SELAMA_DI_RUANG_BAYI);
        this.imunisasiYangTelahDiberikan = object.getString(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_IMUNISASI_YANG_TELAH_DIBERIKAN);
        this.pengobatanYangTelahDiberikan = object.getString(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_PENGOBATAN_YANG_TELAH_DIBERIKAN);
        this.pemeriksaanLain = object.getString(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_PEMERIKSAAN_LAIN);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    @Override
    public String toString() {
        return "ModelRiwayatKesehatanBayi{" +
                "index=" + index +
                ", kesehatanBayiSaatLahir='" + kesehatanBayiSaatLahir + '\'' +
                ", kesehatanBayiSelamaDiRuangBayi='" + kesehatanBayiSelamaDiRuangBayi + '\'' +
                ", imunisasiYangTelahDiberikan='" + imunisasiYangTelahDiberikan + '\'' +
                ", pengobatanYangTelahDiberikan='" + pengobatanYangTelahDiberikan + '\'' +
                ", pemeriksaanLain='" + pemeriksaanLain + '\'' +
                '}';
    }
}
