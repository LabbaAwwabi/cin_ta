package net.laili.pasporbayi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class AppSessionManager {

    private SharedPreferences pref;
    private Editor editor;
    private Context _context;
    private int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "passpor_bayi_session_manager";
    private static final String IS_LOGGED_IN = "isLogedIn";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    /*
     * Constructor
     * */
    public AppSessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Menyimpan data user
     * @param email email user
     */
    public void setEmailUser(String email){
        editor.putString(KEY_EMAIL, email);

        editor.putBoolean(IS_LOGGED_IN, true);
        editor.apply();
    }

    /**
     * Mendapatkan data user
     * @return email user yang login
     */
    public String getEmailUser(){
        return pref.getString(KEY_EMAIL, null);
    }

    /**
     * Menghapus data user, tapi menyisakan attribut email untuk autofill form login
     */
    public void clearDataUser(){
        editor.clear();
        editor.apply();
    }

    // Get User State
    public boolean isUserLoggedIn(){
        return pref.getBoolean(IS_LOGGED_IN, false);
    }
}