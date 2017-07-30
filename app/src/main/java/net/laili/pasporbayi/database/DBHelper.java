package net.laili.pasporbayi.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.laili.pasporbayi.BuildConfig;

/**
 * Created by Bend on 7/30/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper instance;

    public static synchronized DBHelper getInstance(Context context){
        if(instance == null) instance = new DBHelper(context);

        return instance;
    }

    private static int DB_VERSION = 1;

    public static final String COLUMN_INDEX = "index";

    public static final String TABLE_CATATAN_IMUNISASI = "catatan_imunisasi";
    public static final String COLUMN_CATATAN_IMUNISASI_IMUNISASI = "imunisasi";
    public static final String COLUMN_CATATAN_IMUNISASI_UMUR = "umur";
    public static final String COLUMN_CATATAN_IMUNISASI_TANGGAL = "tanggal";
    private static final String CREATE_TABLE_CATATAN_IMUNISASI = "CREATE TABLE `" + TABLE_CATATAN_IMUNISASI + "`(" +
            "`" + COLUMN_INDEX + "` INTEGER PRIMARY KEY, " +
            "`" +COLUMN_CATATAN_IMUNISASI_IMUNISASI+ "` TEXT, " +
            "`" +COLUMN_CATATAN_IMUNISASI_UMUR+ "` TEXT, " +
            "`" +COLUMN_CATATAN_IMUNISASI_TANGGAL+ "` TEXT); ";

    public static final String TABLE_CATATAN_KUNJUNGAN = "catatan_kunjungan";
    public static final String COLUMN_CATATAN_KUNJUNGAN_TANGGAL = "tanggal";
    public static final String COLUMN_CATATAN_KUNJUNGAN_UMUR = "umur";
    public static final String COLUMN_CATATAN_KUNJUNGAN_BB = "bb";
    public static final String COLUMN_CATATAN_KUNJUNGAN_PB = "pb";
    public static final String COLUMN_CATATAN_KUNJUNGAN_LK = "lk";
    public static final String COLUMN_CATATAN_KUNJUNGAN_PEMERIKSAAN = "pemeriksaan";
    public static final String COLUMN_CATATAN_KUNJUNGAN_PENGOBATAN = "pengobatan";
    private static final String CREATE_TABLE_CATATAN_KUNJUNGAN = "CREATE TABLE `" + TABLE_CATATAN_KUNJUNGAN + "`(" +
            "`" + COLUMN_INDEX + "` INTEGER PRIMARY KEY, " +
            "`" +COLUMN_CATATAN_KUNJUNGAN_TANGGAL+ "` TEXT, " +
            "`" +COLUMN_CATATAN_KUNJUNGAN_UMUR+ "` TEXT, " +
            "`" +COLUMN_CATATAN_KUNJUNGAN_BB+ "` TEXT, " +
            "`" +COLUMN_CATATAN_KUNJUNGAN_PB+ "` TEXT, " +
            "`" +COLUMN_CATATAN_KUNJUNGAN_LK+ "` TEXT, " +
            "`" +COLUMN_CATATAN_KUNJUNGAN_PEMERIKSAAN+ "` TEXT, " +
            "`" +COLUMN_CATATAN_KUNJUNGAN_PENGOBATAN+ "` TEXT);";

    public static final String TABLE_DATA_ANAK = "data_anak";
    public static final String COLUMN_DATA_ANAK_NAMA = "nama";
    public static final String COLUMN_DATA_ANAK_TANGGAL_LAHIR = "tanggal_lahir";
    public static final String COLUMN_DATA_ANAK_WAKTU = "waktu";
    public static final String COLUMN_DATA_ANAK_BERAT = "berat";
    public static final String COLUMN_DATA_ANAK_PANJANG = "panjang";
    public static final String COLUMN_DATA_ANAK_LINGKAR_KEPALA = "lingkar_kepala";
    public static final String COLUMN_DATA_ANAK_TEMPAT_LAHIR = "tempat_lahir";
    public static final String COLUMN_DATA_ANAK_RUMAH_SAKIT = "rumah_sakit";
    public static final String COLUMN_DATA_ANAK_NAMA_AYAH = "nama_ayah";
    public static final String COLUMN_DATA_ANAK_TTL_AYAH = "tempat_tanggal_lahir_ayah";
    public static final String COLUMN_DATA_ANAK_PEKERJAAN_AYAH = "pekerjaan_ayah";
    public static final String COLUMN_DATA_ANAK_ALAMAT_KANTOR_AYAH = "alamat_kantor_ayah";
    public static final String COLUMN_DATA_ANAK_TELEPON_KANTOR_AYAH = "telepon_kantor_ayah";
    public static final String COLUMN_DATA_ANAK_TELEPON_SELULER_AYAH = "telepon_seluler_ayah";
    public static final String COLUMN_DATA_ANAK_NAMA_IBU = "nama_ibu";
    public static final String COLUMN_DATA_ANAK_TTL_IBU = "tempat_tanggal_lahir_ibu";
    public static final String COLUMN_DATA_ANAK_PEKERJAAN_IBU = "pekerjaan_ibu";
    public static final String COLUMN_DATA_ANAK_ALAMAT_KANTOR_IBU = "alamat_kantor_ibu";
    public static final String COLUMN_DATA_ANAK_TELEPON_KANTOR_IBU = "telepon_kantor_ibu";
    public static final String COLUMN_DATA_ANAK_TELEPON_SELULER_IBU = "telepon_seluler_ibu";
    public static final String COLUMN_DATA_ANAK_NAMA_DOKTER_KANDUNGAN = "nama_dokter_kandungan";
    public static final String COLUMN_DATA_ANAK_NAMA_DOKTER_ANAK = "nama_dokter_anak";
    public static final String COLUMN_DATA_ANAK_KONDISI_ATAU_SARAN = "kondisi_atau_saran_khusus";
    public static final String COLUMN_DATA_ANAK_JENIS_KELAMIN_ANAK = "jenis_kelamin_anak";
    private static final String CREATE_TABLE_DATA_ANAK = "CREATE TABLE `" + TABLE_DATA_ANAK + "`(" +
            "`" + COLUMN_INDEX + "` INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "`" +COLUMN_DATA_ANAK_NAMA+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_TANGGAL_LAHIR+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_WAKTU+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_BERAT+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_PANJANG+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_LINGKAR_KEPALA+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_TEMPAT_LAHIR+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_RUMAH_SAKIT+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_NAMA_AYAH+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_TTL_AYAH+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_PEKERJAAN_AYAH+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_ALAMAT_KANTOR_AYAH+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_TELEPON_KANTOR_AYAH+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_TELEPON_SELULER_AYAH+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_NAMA_IBU+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_TTL_IBU+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_PEKERJAAN_IBU+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_ALAMAT_KANTOR_IBU+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_TELEPON_KANTOR_IBU+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_TELEPON_SELULER_IBU+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_NAMA_DOKTER_KANDUNGAN+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_NAMA_DOKTER_ANAK+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_KONDISI_ATAU_SARAN+ "` TEXT, " +
            "`" +COLUMN_DATA_ANAK_JENIS_KELAMIN_ANAK+ "` TEXT);";

    public static final String TABLE_PERKEMBANGAN_BAYI = "perkembangan_bayi";
    public static final String COLUMN_PERKEMBANGAN_BAYI_UMUR = "umur";
    public static final String COLUMN_PERKEMBANGAN_BAYI_TIPE = "tipe";
    public static final String COLUMN_PERKEMBANGAN_BAYI_DETAIL = "detail";
    public static final String COLUMN_PERKEMBANGAN_BAYI_STATUS = "status";
    private static final String CREATE_TABLE_PERKEMBANGAN_BAYI = "CREATE TABLE `" + TABLE_PERKEMBANGAN_BAYI + "`(" +
            "`" + COLUMN_INDEX + "` INTEGER PRIMARY KEY, " +
            "`" +COLUMN_PERKEMBANGAN_BAYI_UMUR+ "` TEXT, " +
            "`" +COLUMN_PERKEMBANGAN_BAYI_TIPE+ "` TEXT, " +
            "`" +COLUMN_PERKEMBANGAN_BAYI_DETAIL+ "` TEXT, " +
            "`" +COLUMN_PERKEMBANGAN_BAYI_STATUS+ "` INT);";

    public static final String TABLE_RIWAYAT_KELAHIRAN = "riwayat_kelahiran";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_TANGGAL_LAHIR = "tanggal_lahir";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_NAMA_RUMAH_SAKIT = "nama_rumah_sakit";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_PENOLONG_PERSALINAN = "penolong_persalinan";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_UMUR_KELAHIRAN = "umur_kelahiran";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_LETAK_JANIN = "letak_janin";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_CARA_LAHIR = "cara_lahir";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_APGAR_SCOPE = "apgar_scope";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_BERAT_BADAN_LAHIR = "berat_badan_lahir";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_PANJANG_BADAN_LAHIR = "panjang_badan_lahir";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_LINGKAR_KEPALA = "lingkar_kepala";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_LINGKAR_DADA = "lingkar_dada";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_TALI_PUSAT = "tali_pusat";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_AIR_KETUBAN = "air_ketuban";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_BERAT_PLACENTA = "berat_placenta";
    public static final String COLUMN_RIWAYAT_KELAHIRAN_GOLONGAN_DARAH = "golongan_darah";
    private static final String CREATE_TABLE_RIWAYAT_KELAHIRAN = "CREATE TABLE `" + TABLE_RIWAYAT_KELAHIRAN + "`(" +
            "`" + COLUMN_INDEX + "` INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_TANGGAL_LAHIR+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_NAMA_RUMAH_SAKIT+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_PENOLONG_PERSALINAN+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_UMUR_KELAHIRAN+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_LETAK_JANIN+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_CARA_LAHIR+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_APGAR_SCOPE+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_BERAT_BADAN_LAHIR+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_PANJANG_BADAN_LAHIR+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_LINGKAR_KEPALA+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_LINGKAR_DADA+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_TALI_PUSAT+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_AIR_KETUBAN+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_BERAT_PLACENTA+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KELAHIRAN_GOLONGAN_DARAH+ "` TEXT);";

    public static final String TABLE_RIWAYAT_KESEHATAN_BAYI = "riwayat_kesehatan_bayi";
    public static final String COLUMN_RIWAYAT_KESEHATAN_BAYI_KESEHATAN_BAYI_SAAT_LAHIR = "kesehatan_bayi_saat_lahir";
    public static final String COLUMN_RIWAYAT_KESEHATAN_BAYI_KESEHATAN_BAYI_SELAMA_DI_RUANG_BAYI = "kesehatan_bayi_selama_di_ruang_bayi";
    public static final String COLUMN_RIWAYAT_KESEHATAN_BAYI_IMUNISASI_YANG_TELAH_DIBERIKAN = "imunisasi_yang_telah_diberikan";
    public static final String COLUMN_RIWAYAT_KESEHATAN_BAYI_PENGOBATAN_YANG_TELAH_DIBERIKAN = "pengobatan_yang_telah_diberikan";
    public static final String COLUMN_RIWAYAT_KESEHATAN_BAYI_PEMERIKSAAN_LAIN = "pemeriksaan_lain";
    private static final String CREATE_TABLE_RIWAYAT_KESEHATAN_BAYI = "CREATE TABLE `" + TABLE_RIWAYAT_KESEHATAN_BAYI + "`(" +
            "`" + COLUMN_INDEX + "` INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "`" +COLUMN_RIWAYAT_KESEHATAN_BAYI_KESEHATAN_BAYI_SAAT_LAHIR+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KESEHATAN_BAYI_KESEHATAN_BAYI_SELAMA_DI_RUANG_BAYI+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KESEHATAN_BAYI_IMUNISASI_YANG_TELAH_DIBERIKAN+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KESEHATAN_BAYI_PENGOBATAN_YANG_TELAH_DIBERIKAN+ "` TEXT, " +
            "`" +COLUMN_RIWAYAT_KESEHATAN_BAYI_PEMERIKSAAN_LAIN+ "` TEXT);";


    public DBHelper(Context context) {
        super(context, BuildConfig.DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CATATAN_IMUNISASI);
        db.execSQL(CREATE_TABLE_CATATAN_KUNJUNGAN);
        db.execSQL(CREATE_TABLE_DATA_ANAK);
        db.execSQL(CREATE_TABLE_PERKEMBANGAN_BAYI);
        db.execSQL(CREATE_TABLE_RIWAYAT_KELAHIRAN);
        db.execSQL(CREATE_TABLE_RIWAYAT_KESEHATAN_BAYI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_CATATAN_IMUNISASI);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_CATATAN_KUNJUNGAN);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_DATA_ANAK);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_PERKEMBANGAN_BAYI);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_RIWAYAT_KELAHIRAN);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_RIWAYAT_KESEHATAN_BAYI);
    }
}
