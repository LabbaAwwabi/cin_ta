package net.laili.pasporbayi.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import net.laili.pasporbayi.R;
import net.laili.pasporbayi.auth.LoginActivity;
import net.laili.pasporbayi.database.DBHelper;
import net.laili.pasporbayi.database.DaoCatatanImunisasi;
import net.laili.pasporbayi.database.DaoPerkembanganBayi;
import net.laili.pasporbayi.models.ModelCatatanImunisasi;
import net.laili.pasporbayi.models.ModelPerkembanganBayi;
import net.laili.pasporbayi.utils.AppController;
import net.laili.pasporbayi.utils.AppSessionManager;
import net.laili.pasporbayi.utils.Constants;
import net.laili.pasporbayi.utils.CustomRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LauncherActivity extends AppCompatActivity {

    private DaoPerkembanganBayi daoPerkembanganBayi;
    private DaoCatatanImunisasi daoCatatanImunisasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        DBHelper.getInstance(getApplicationContext());
        setContentView(R.layout.activity_launcher);

        daoPerkembanganBayi = DaoPerkembanganBayi.getInstance(getApplicationContext());
        daoCatatanImunisasi = DaoCatatanImunisasi.getInstance(getApplicationContext());

        Toast.makeText(this, "PB : " +daoPerkembanganBayi.find().size(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "CI : " +daoCatatanImunisasi.find().size(), Toast.LENGTH_SHORT).show();

        if (daoPerkembanganBayi.find().size() <= 0 && daoCatatanImunisasi.find().size() <= 0) {
            inisialisasi();
        } else {
            //inisialisasi();
            delay(2000);
        }
    }

    public void inisialisasi() {
        final String urlJsonObj = Constants.INISIALISASI_URL;

        CustomRequest jsonObjReq = new CustomRequest(urlJsonObj, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    int status = response.getInt(Constants.JSON_STATUS);
                    String message = response.getString(Constants.JSON_MESSAGE);

                    if (status == Constants.SUCCESS_RESPONSE) {
                        JSONArray tables = response.getJSONArray(Constants.JSON_TABLE);

                        JSONArray dataCatatanImunisasi = tables.getJSONObject(0).getJSONArray(Constants.JSON_DATA);
                        JSONArray dataPerkembanganBayi = tables.getJSONObject(1).getJSONArray(Constants.JSON_DATA);

                        for (int i = 0; i < dataCatatanImunisasi.length(); i++) {
                            JSONObject catatanImunisasi = dataCatatanImunisasi.getJSONObject(i);
                            boolean sql = daoCatatanImunisasi.insert(new ModelCatatanImunisasi(catatanImunisasi));
                            //Log.i("trace", catatanImunisasi.toString());
                            Log.i("trace", "imun " + i + (sql?"sukses":"gagal"));
                        }
                        Log.i("trace", "imunisasi : " + daoCatatanImunisasi.find().size());

                        for (int i = 0; i < dataPerkembanganBayi.length(); i++) {
                            JSONObject perkembanganBayi = dataPerkembanganBayi.getJSONObject(i);
                            daoPerkembanganBayi.insert(new ModelPerkembanganBayi(perkembanganBayi));
                            //Log.i("trace", perkembanganBayi.toString());
                        }
                        Log.i("trace", "perkembangan : " + daoPerkembanganBayi.find().size());

                        delay(1000);
                    } else {
                        Toast.makeText(LauncherActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(LauncherActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    forceExit();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LauncherActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                forceExit();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    private void delay(int delayTime) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                AppSessionManager appSessionManager = new AppSessionManager(getApplicationContext());
                Intent intent;
                if (appSessionManager.isUserLoggedIn()) {
                    intent = new Intent(LauncherActivity.this, MainActivity.class);
                } else {
                    intent = new Intent(LauncherActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, delayTime);
    }

    private void forceExit() {
        finish();
    }
}
