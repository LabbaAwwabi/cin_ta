package net.laili.pasporbayi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.laili.pasporbayi.models.ModelRiwayatKesehatanBayi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bend on 7/30/2017.
 */

public class DaoRiwayatKesehatanBayi {

    private static DaoRiwayatKesehatanBayi instance;
    private SQLiteDatabase db;
    private String tableName = DBHelper.TABLE_RIWAYAT_KESEHATAN_BAYI;

    public static synchronized DaoRiwayatKesehatanBayi getInstance(Context context){
        if(instance == null) instance = new DaoRiwayatKesehatanBayi(context);

        return instance;
    }

    private DaoRiwayatKesehatanBayi(Context context){
        db = DBHelper.getInstance(context).getWritableDatabase();
    }

    public List<ModelRiwayatKesehatanBayi> find(){
        List<ModelRiwayatKesehatanBayi> models = new ArrayList<>();
        String query = "SELECT * FROM " +tableName+ " WHERE 1";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0){
            do{
                models.add(new ModelRiwayatKesehatanBayi(cursor));
            }while (cursor.moveToNext());
        }

        cursor.close();
        return models;
    }

    /**
     *
     * @param model
     * @return true if insert successfully
     */
    public boolean insert(ModelRiwayatKesehatanBayi model){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_KESEHATAN_BAYI_SAAT_LAHIR, model.getKesehatanBayiSaatLahir());
        cv.put(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_KESEHATAN_BAYI_SELAMA_DI_RUANG_BAYI, model.getKesehatanBayiSelamaDiRuangBayi());
        cv.put(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_IMUNISASI_YANG_TELAH_DIBERIKAN, model.getImunisasiYangTelahDiberikan());
        cv.put(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_PENGOBATAN_YANG_TELAH_DIBERIKAN, model.getPengobatanYangTelahDiberikan());
        cv.put(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_PEMERIKSAAN_LAIN, model.getPemeriksaanLain());

        return db.insert(tableName, null, cv) != -1;
    }

    public void update(ModelRiwayatKesehatanBayi model){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_KESEHATAN_BAYI_SAAT_LAHIR, model.getKesehatanBayiSaatLahir());
        cv.put(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_KESEHATAN_BAYI_SELAMA_DI_RUANG_BAYI, model.getKesehatanBayiSelamaDiRuangBayi());
        cv.put(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_IMUNISASI_YANG_TELAH_DIBERIKAN, model.getImunisasiYangTelahDiberikan());
        cv.put(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_PENGOBATAN_YANG_TELAH_DIBERIKAN, model.getPengobatanYangTelahDiberikan());
        cv.put(DBHelper.COLUMN_RIWAYAT_KESEHATAN_BAYI_PEMERIKSAAN_LAIN, model.getPemeriksaanLain());

        db.update(tableName, cv, DBHelper.COLUMN_ID +"=?", new String[]{""+model.getIndex()});
    }

    public void remove(){
        db.delete(tableName, null, null);
    }
}
