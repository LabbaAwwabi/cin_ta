package net.laili.pasporbayi.auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import net.laili.pasporbayi.R;
import net.laili.pasporbayi.activities.MainActivity;
import net.laili.pasporbayi.utils.AppController;
import net.laili.pasporbayi.utils.AppSessionManager;
import net.laili.pasporbayi.utils.Constants;
import net.laili.pasporbayi.utils.CustomRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener, Validator.ValidationListener {

    @NotEmpty
    @BindView(R.id.input_nama)
    EditText inputNama;

    @NotEmpty
    @Email
    @BindView(R.id.input_email)
    EditText inputEmail;

    @NotEmpty
    @Password
    @BindView(R.id.input_password)
    EditText inputPassword;

    @ConfirmPassword
    @BindView(R.id.input_konfirm_password)
    EditText inputReEnterPasword;

    @BindView(R.id.btn_daftar)
    Button buttonDaftar;
    @BindView(R.id.link_login)
    TextView linkLogin;

    private AppSessionManager appSessionManager;
    private Validator validator;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);

        appSessionManager = new AppSessionManager(this);

        validator = new Validator(this);
        validator.setValidationListener(this);

        buttonDaftar.setOnClickListener(this);
        linkLogin.setOnClickListener(this);

        progressDialog = new ProgressDialog(this,
                R.style.AppTheme_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Harap Tunggu...");
    }

    @Override
    public void onClick(View view) {
        int idView = view.getId();

        switch (idView) {
            case R.id.btn_daftar:
                validator.validate();
                break;
            case R.id.link_login:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void onValidationSucceeded() {
        Map<String, String> params = new HashMap<>();
        params.put(AppSessionManager.KEY_NAMA, inputNama.getText().toString().trim());
        params.put(AppSessionManager.KEY_EMAIL, inputEmail.getText().toString().trim());
        params.put(AppSessionManager.KEY_PASSWORD, inputPassword.getText().toString().trim());

        daftar(params);
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

    public void daftar(final Map<String, String> params) {
        progressDialog.show();

        final String urlJsonObj = Constants.REGISTRATION_URL;

        CustomRequest jsonObjReq = new CustomRequest(Request.Method.POST, urlJsonObj, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    int status = response.getInt(Constants.JSON_STATUS);
                    String message = response.getString(Constants.JSON_MESSAGE);

                    if (status == Constants.SUCCESS_RESPONSE) {
                        appSessionManager.setLoginState(true);
                        appSessionManager.setEmailUser(params.get(AppSessionManager.KEY_EMAIL));
                        appSessionManager.setNamaUser(params.get(AppSessionManager.KEY_NAMA));
                        Toast.makeText(RegistrationActivity.this, message, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(RegistrationActivity.this, message, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(RegistrationActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegistrationActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
