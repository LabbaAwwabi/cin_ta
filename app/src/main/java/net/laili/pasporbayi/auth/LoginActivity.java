package net.laili.pasporbayi.auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import net.laili.pasporbayi.activities.MainActivity;
import net.laili.pasporbayi.R;
import net.laili.pasporbayi.database.DBHelper;
import net.laili.pasporbayi.database.DaoCatatanImunisasi;
import net.laili.pasporbayi.database.DaoCatatanKunjungan;
import net.laili.pasporbayi.database.DaoDataAnak;
import net.laili.pasporbayi.database.DaoPerkembanganBayi;
import net.laili.pasporbayi.database.DaoRiwayatKelahiran;
import net.laili.pasporbayi.database.DaoRiwayatKesehatanBayi;
import net.laili.pasporbayi.models.ModelCatatanImunisasi;
import net.laili.pasporbayi.models.ModelCatatanKunjungan;
import net.laili.pasporbayi.models.ModelDataAnak;
import net.laili.pasporbayi.models.ModelPerkembanganBayi;
import net.laili.pasporbayi.models.ModelRiwayatKelahiran;
import net.laili.pasporbayi.models.ModelRiwayatKesehatanBayi;
import net.laili.pasporbayi.utils.AppController;
import net.laili.pasporbayi.utils.AppSessionManager;
import net.laili.pasporbayi.utils.Constants;
import net.laili.pasporbayi.utils.CustomRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, Validator.ValidationListener{

    @NotEmpty
    @Email
    @BindView(R.id.input_email)
    EditText inputEmail;

    @NotEmpty
    @Password
    @BindView(R.id.input_password)
    EditText inputPassword;

    @BindView(R.id.btn_login)
    Button buttonLogin;
    @BindView(R.id.link_daftar)
    TextView linkDaftar;

    private AppSessionManager appSessionManager;
    private Validator validator;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        appSessionManager = new AppSessionManager(this);

        validator = new Validator(this);
        validator.setValidationListener(this);

        buttonLogin.setOnClickListener(this);
        linkDaftar.setOnClickListener(this);

        progressDialog = new ProgressDialog(this,
                R.style.AppTheme_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Harap Tunggu...");
    }

    @Override
    public void onClick(View view) {
        int idView = view.getId();
        switch (idView) {
            case R.id.btn_login:
                validator.validate();
                break;
            case R.id.link_daftar:
                startActivity(new Intent(this, RegistrationActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void onValidationSucceeded() {
        Map<String, String> params = new HashMap<>();
        params.put(AppSessionManager.KEY_EMAIL, inputEmail.getText().toString());
        params.put(AppSessionManager.KEY_PASSWORD, inputPassword.getText().toString());

        login(params);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        //menampilkan pesan error
        for (ValidationError validation : errors) {
            View view = validation.getView();
            String message = validation.getFailedRules().get(0).getMessage(this);

            if (view instanceof EditText)
                ((EditText) view).setError(message);
            else
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    public void login(final Map<String, String> params) {
        progressDialog.show();

        final String urlJsonObj = Constants.LOGIN_URL;

        CustomRequest jsonObjReq = new CustomRequest(Request.Method.POST, urlJsonObj, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    int status = response.getInt(Constants.JSON_STATUS);
                    String message = response.getString(Constants.JSON_MESSAGE);

                    if (status == Constants.SUCCESS_RESPONSE) {
                        JSONObject data = response.getJSONObject(Constants.JSON_DATA);

                        if (data != null) {
                            appSessionManager.setLoginState(true);
                            appSessionManager.setEmailUser(params.get(AppSessionManager.KEY_EMAIL));
                            appSessionManager.setNamaUser(data.getString(AppSessionManager.KEY_NAMA));
                            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                            createDaoSession(data);
                            progressDialog.dismiss();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    private void createDaoSession(JSONObject data) {
        DaoDataAnak daoDataAnak = DaoDataAnak.getInstance(getApplicationContext());
        DaoRiwayatKelahiran daoRiwayatKelahiran = DaoRiwayatKelahiran.getInstance(getApplicationContext());
        DaoRiwayatKesehatanBayi daoRiwayatKesehatanBayi = DaoRiwayatKesehatanBayi.getInstance(getApplicationContext());
        DaoPerkembanganBayi daoPerkembanganBayi = DaoPerkembanganBayi.getInstance(getApplicationContext());
        DaoCatatanImunisasi daoCatatanImunisasi = DaoCatatanImunisasi.getInstance(getApplicationContext());
        DaoCatatanKunjungan daoCatatanKunjungan = DaoCatatanKunjungan.getInstance(getApplicationContext());

        try {
            if (data.getJSONArray(DBHelper.TABLE_DATA_ANAK) != null) {
                JSONArray dataAnak = data.getJSONArray(DBHelper.TABLE_DATA_ANAK);
                for (int i = 0; i < dataAnak.length(); i++) {
                    daoDataAnak.insert(new ModelDataAnak(dataAnak.getJSONObject(i)));
                }
            }
            if (data.getJSONArray(DBHelper.TABLE_RIWAYAT_KELAHIRAN) != null) {
                JSONArray riwayatKelahiran = data.getJSONArray(DBHelper.TABLE_RIWAYAT_KELAHIRAN);
                for (int i = 0; i < riwayatKelahiran.length(); i++) {
                    daoRiwayatKelahiran.insert(new ModelRiwayatKelahiran(riwayatKelahiran.getJSONObject(i)));
                }
            }
            if (data.getJSONArray(DBHelper.TABLE_RIWAYAT_KESEHATAN_BAYI) != null) {
                JSONArray riwayatKesehatan = data.getJSONArray(DBHelper.TABLE_RIWAYAT_KESEHATAN_BAYI);
                for (int i = 0; i < riwayatKesehatan.length(); i++) {
                    daoRiwayatKesehatanBayi.insert(new ModelRiwayatKesehatanBayi(riwayatKesehatan.getJSONObject(i)));
                }
            }
            if (data.getJSONArray(DBHelper.TABLE_PERKEMBANGAN_BAYI) != null) {
                JSONArray perkembanganBayi = data.getJSONArray(DBHelper.TABLE_PERKEMBANGAN_BAYI);
                for (int i = 0; i < perkembanganBayi.length(); i++) {
                    daoPerkembanganBayi.update(new ModelPerkembanganBayi(perkembanganBayi.getJSONObject(i)));
                }
            }
            if (data.getJSONArray(DBHelper.TABLE_CATATAN_IMUNISASI) != null) {
                JSONArray catatanImunisasi = data.getJSONArray(DBHelper.TABLE_CATATAN_IMUNISASI);
                for (int i = 0; i < catatanImunisasi.length(); i++) {
                    daoCatatanImunisasi.update(new ModelCatatanImunisasi(catatanImunisasi.getJSONObject(i)));
                }
            }
            if (data.getJSONArray(DBHelper.TABLE_CATATAN_KUNJUNGAN) != null) {
                JSONArray catatanKunjungan = data.getJSONArray(DBHelper.TABLE_CATATAN_KUNJUNGAN);
                for (int i = 0; i < catatanKunjungan.length(); i++) {
                    daoCatatanKunjungan.insert(new ModelCatatanKunjungan(catatanKunjungan.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
