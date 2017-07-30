package net.laili.pasporbayi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.laili.pasporbayi.models.ModelCatatanKunjungan;
import net.laili.pasporbayi.models.ModelDataAnak;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bend on 7/30/2017.
 */

public class DaoCatatanKunjungan {

    private static DaoCatatanKunjungan instance;
    private SQLiteDatabase db;
    private String tableName = DBHelper.TABLE_CATATAN_KUNJUNGAN;

    public static synchronized DaoCatatanKunjungan getInstance(Context context){
        if(instance == null) instance = new DaoCatatanKunjungan(context);

        return instance;
    }

    private DaoCatatanKunjungan(Context context){
        db = DBHelper.getInstance(context).getWritableDatabase();
    }

    public List<ModelCatatanKunjungan> find(){
        List<ModelCatatanKunjungan> models = new ArrayList<>();
        String query = "SELECT * FROM " +tableName+ " WHERE 1";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0){
            do{
                models.add(new ModelCatatanKunjungan(cursor));
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
    public boolean insert(ModelCatatanKunjungan model){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_INDEX, model.getIndex());
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_TANGGAL, model.getTanggal());
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_UMUR, model.getUmur());
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_BB, model.getBb());
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_PB, model.getPb());
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_LK, model.getLk());
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_PEMERIKSAAN, model.getPemeriksaan());
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_PENGOBATAN, model.getPengobatan());

        return db.insert(tableName, null, cv) != -1;
    }

    public void update(ModelCatatanKunjungan model){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_TANGGAL, model.getTanggal());
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_UMUR, model.getUmur());
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_BB, model.getBb());
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_PB, model.getPb());
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_LK, model.getLk());
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_PEMERIKSAAN, model.getPemeriksaan());
        cv.put(DBHelper.COLUMN_CATATAN_KUNJUNGAN_PENGOBATAN, model.getPengobatan());

        db.update(tableName, cv, DBHelper.COLUMN_INDEX+"=?", new String[]{""+model.getIndex()});
    }

    public void remove(){
        db.delete(tableName, null, null);
    }
}
