package net.laili.pasporbayi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.laili.pasporbayi.models.ModelDataAnak;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bend on 7/30/2017.
 */

public class DaoDataAnak {

    private static DaoDataAnak instance;
    private SQLiteDatabase db;
    private String tableName = DBHelper.TABLE_DATA_ANAK;

    public static synchronized DaoDataAnak getInstance(Context context){
        if(instance == null) instance = new DaoDataAnak(context);

        return instance;
    }

    private DaoDataAnak(Context context){
        db = DBHelper.getInstance(context).getWritableDatabase();
    }

    public List<ModelDataAnak> find(){
        List<ModelDataAnak> models = new ArrayList<>();
        String query = "SELECT * FROM " +tableName+ " WHERE 1";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0){
            do{
                models.add(new ModelDataAnak(cursor));
            }while (cursor.moveToNext());
        }

        cursor.close();
        return models;
    }

    public void insert(ModelDataAnak model){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_DATA_ANAK_NAMA, model.getNama());
        cv.put(DBHelper.COLUMN_DATA_ANAK_TANGGAL_LAHIR, model.getTanggalLahir());
        cv.put(DBHelper.COLUMN_DATA_ANAK_WAKTU, model.getWaktu());
        cv.put(DBHelper.COLUMN_DATA_ANAK_BERAT, model.getBerat());
        cv.put(DBHelper.COLUMN_DATA_ANAK_PANJANG, model.getPanjang());
        cv.put(DBHelper.COLUMN_DATA_ANAK_LINGKAR_KEPALA, model.getLingkarKepala());
        cv.put(DBHelper.COLUMN_DATA_ANAK_TEMPAT_LAHIR, model.getTempatLahir());
        cv.put(DBHelper.COLUMN_DATA_ANAK_RUMAH_SAKIT, model.getRumahSakit());
        cv.put(DBHelper.COLUMN_DATA_ANAK_NAMA_AYAH, model.getNama());
        cv.put(DBHelper.COLUMN_DATA_ANAK_TTL_AYAH, model.getTempatTanggalLahirAyah());
        cv.put(DBHelper.COLUMN_DATA_ANAK_PEKERJAAN_AYAH, model.getPekerjaanAyah());
        cv.put(DBHelper.COLUMN_DATA_ANAK_ALAMAT_KANTOR_AYAH, model.getAlamatKantorAyah());
        cv.put(DBHelper.COLUMN_DATA_ANAK_TELEPON_KANTOR_AYAH, model.getTeleponKantorAyah());
        cv.put(DBHelper.COLUMN_DATA_ANAK_TELEPON_SELULER_AYAH, model.getTeleponSelulerAyah());
        cv.put(DBHelper.COLUMN_DATA_ANAK_NAMA_IBU, model.getNamaIbu());
        cv.put(DBHelper.COLUMN_DATA_ANAK_TTL_IBU, model.getTempatTanggalLahirIbu());
        cv.put(DBHelper.COLUMN_DATA_ANAK_PEKERJAAN_IBU, model.getPekerjaanIbu());
        cv.put(DBHelper.COLUMN_DATA_ANAK_ALAMAT_KANTOR_IBU, model.getAlamatKantorIbu());
        cv.put(DBHelper.COLUMN_DATA_ANAK_TELEPON_KANTOR_IBU, model.getTeleponKantorIbu());
        cv.put(DBHelper.COLUMN_DATA_ANAK_TELEPON_SELULER_IBU, model.getTeleponSelulerIbu());
        cv.put(DBHelper.COLUMN_DATA_ANAK_NAMA_DOKTER_KANDUNGAN, model.getNamaDokterKandungan());
        cv.put(DBHelper.COLUMN_DATA_ANAK_NAMA_DOKTER_ANAK, model.getNamaDokterAnak());
        cv.put(DBHelper.COLUMN_DATA_ANAK_KONDISI_ATAU_SARAN, model.getKondisiAtauSaranKhusus());
        cv.put(DBHelper.COLUMN_DATA_ANAK_JENIS_KELAMIN_ANAK, model.getJenisKelaminAnak());

        db.insert(tableName, null, cv);
    }
}
