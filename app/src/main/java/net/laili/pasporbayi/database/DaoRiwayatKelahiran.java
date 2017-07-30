package net.laili.pasporbayi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.laili.pasporbayi.models.ModelDataAnak;
import net.laili.pasporbayi.models.ModelRiwayatKelahiran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bend on 7/30/2017.
 */

public class DaoRiwayatKelahiran {

    private static DaoRiwayatKelahiran instance;
    private SQLiteDatabase db;
    private String tableName = DBHelper.TABLE_RIWAYAT_KELAHIRAN;

    public static synchronized DaoRiwayatKelahiran getInstance(Context context){
        if(instance == null) instance = new DaoRiwayatKelahiran(context);

        return instance;
    }

    private DaoRiwayatKelahiran(Context context){
        db = DBHelper.getInstance(context).getWritableDatabase();
    }

    public List<ModelRiwayatKelahiran> find(){
        List<ModelRiwayatKelahiran> models = new ArrayList<>();
        String query = "SELECT * FROM " +tableName+ " WHERE 1";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0){
            do{
                models.add(new ModelRiwayatKelahiran(cursor));
            }while (cursor.moveToNext());
        }

        cursor.close();
        return models;
    }

    public void insert(ModelRiwayatKelahiran model){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_TANGGAL_LAHIR, model.getTanggalLahir());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_NAMA_RUMAH_SAKIT, model.getNamaRumahSakit());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_PENOLONG_PERSALINAN, model.getPenolongPersalinan());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_UMUR_KELAHIRAN, model.getUmurKelahiran());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_LETAK_JANIN, model.getLetakJanin());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_CARA_LAHIR, model.getCaraLahir());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_APGAR_SCOPE, model.getApgarScope());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_BERAT_BADAN_LAHIR, model.getBeratBadanLahir());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_PANJANG_BADAN_LAHIR, model.getPanjangBadanLahir());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_LINGKAR_KEPALA, model.getLingkarKepala());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_LINGKAR_DADA, model.getLingkarDada());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_TALI_PUSAT, model.getTaliPusat());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_AIR_KETUBAN, model.getAirKetuban());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_BERAT_PLACENTA, model.getBeratPlacenta());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_GOLONGAN_DARAH, model.getGolonganDarah());

        db.insert(tableName, null, cv);
    }

    public void update(ModelRiwayatKelahiran model){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_TANGGAL_LAHIR, model.getTanggalLahir());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_NAMA_RUMAH_SAKIT, model.getNamaRumahSakit());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_PENOLONG_PERSALINAN, model.getPenolongPersalinan());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_UMUR_KELAHIRAN, model.getUmurKelahiran());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_LETAK_JANIN, model.getLetakJanin());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_CARA_LAHIR, model.getCaraLahir());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_APGAR_SCOPE, model.getApgarScope());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_BERAT_BADAN_LAHIR, model.getBeratBadanLahir());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_PANJANG_BADAN_LAHIR, model.getPanjangBadanLahir());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_LINGKAR_KEPALA, model.getLingkarKepala());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_LINGKAR_DADA, model.getLingkarDada());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_TALI_PUSAT, model.getTaliPusat());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_AIR_KETUBAN, model.getAirKetuban());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_BERAT_PLACENTA, model.getBeratPlacenta());
        cv.put(DBHelper.COLUMN_RIWAYAT_KELAHIRAN_GOLONGAN_DARAH, model.getGolonganDarah());

        db.update(tableName, cv, DBHelper.COLUMN_INDEX+"=?", new String[]{""+model.getIndex()});
    }

    public void remove(){
        db.delete(tableName, null, null);
    }
}
