package net.laili.pasporbayi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.laili.pasporbayi.models.ModelCatatanKunjungan;
import net.laili.pasporbayi.models.ModelPerkembanganBayi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bend on 7/30/2017.
 */

public class DaoPerkembanganBayi {

    private static DaoPerkembanganBayi instance;
    private SQLiteDatabase db;
    private String tableName = DBHelper.TABLE_PERKEMBANGAN_BAYI;

    public static synchronized DaoPerkembanganBayi getInstance(Context context){
        if(instance == null) instance = new DaoPerkembanganBayi(context);

        return instance;
    }

    private DaoPerkembanganBayi(Context context){
        db = DBHelper.getInstance(context).getWritableDatabase();
    }

    public List<ModelPerkembanganBayi> find(){
        List<ModelPerkembanganBayi> models = new ArrayList<>();
        String query = "SELECT * FROM " +tableName+ " WHERE 1";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0){
            do{
                models.add(new ModelPerkembanganBayi(cursor));
            }while (cursor.moveToNext());
        }

        cursor.close();
        return models;
    }

    public boolean insert(ModelPerkembanganBayi model){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_INDEX, model.getIndex());
        cv.put(DBHelper.COLUMN_PERKEMBANGAN_BAYI_UMUR, model.getUmur());
        cv.put(DBHelper.COLUMN_PERKEMBANGAN_BAYI_TIPE, model.getTipe());
        cv.put(DBHelper.COLUMN_PERKEMBANGAN_BAYI_DETAIL, model.getDetail());
        cv.put(DBHelper.COLUMN_PERKEMBANGAN_BAYI_STATUS, 0);

        return db.insert(tableName, null, cv) != -1;
    }

    public void update(ModelPerkembanganBayi model){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_PERKEMBANGAN_BAYI_STATUS, model.getStatus());

        db.update(tableName, cv, DBHelper.COLUMN_INDEX+"=?", new String[]{""+model.getIndex()});
    }

    public void reset(){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_PERKEMBANGAN_BAYI_STATUS, 0);

        db.update(tableName, cv, null, null);
    }
}
