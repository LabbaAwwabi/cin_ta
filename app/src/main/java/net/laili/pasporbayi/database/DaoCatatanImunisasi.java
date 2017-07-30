package net.laili.pasporbayi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.laili.pasporbayi.models.ModelCatatanImunisasi;
import net.laili.pasporbayi.models.ModelPerkembanganBayi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bend on 7/30/2017.
 */

public class DaoCatatanImunisasi {

    private static DaoCatatanImunisasi instance;
    private SQLiteDatabase db;
    private String tableName = DBHelper.TABLE_CATATAN_IMUNISASI;

    public static synchronized DaoCatatanImunisasi getInstance(Context context){
        if(instance == null) instance = new DaoCatatanImunisasi(context);

        return instance;
    }

    private DaoCatatanImunisasi(Context context){
        db = DBHelper.getInstance(context).getWritableDatabase();
    }

    public List<ModelCatatanImunisasi> find(){
        List<ModelCatatanImunisasi> models = new ArrayList<>();
        String query = "SELECT * FROM " +tableName+ " WHERE 1";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0){
            do{
                models.add(new ModelCatatanImunisasi(cursor));
            }while (cursor.moveToNext());
        }

        cursor.close();
        return models;
    }

    public boolean insert(ModelCatatanImunisasi model){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_INDEX, model.getIndex());
        cv.put(DBHelper.COLUMN_CATATAN_IMUNISASI_IMUNISASI, model.getImunisasi());
        cv.put(DBHelper.COLUMN_CATATAN_IMUNISASI_UMUR, model.getUmur());
        cv.put(DBHelper.COLUMN_CATATAN_IMUNISASI_TANGGAL, "");

        return db.insert(tableName, "''", cv) != -1;
    }

    public void update(ModelCatatanImunisasi model){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_CATATAN_IMUNISASI_TANGGAL, model.getTanggal());

        db.update(tableName, cv, DBHelper.COLUMN_INDEX+"=?", new String[]{""+model.getIndex()});
    }

    public void reset(){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_CATATAN_IMUNISASI_TANGGAL, "");

        db.update(tableName, cv, null, null);
    }
}
