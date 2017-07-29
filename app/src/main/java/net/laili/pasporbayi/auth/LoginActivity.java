package net.laili.pasporbayi.auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
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

import net.laili.pasporbayi.MainActivity;
import net.laili.pasporbayi.R;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, Validator.ValidationListener{

    @NotEmpty
    @Email
    EditText inputEmail;

    @NotEmpty
    @Password
    EditText inputPassword;

    @BindView(R.id.btn_login)
    Button buttonLogin;
    @BindView(R.id.link_signup)
    TextView linkSignUp;

    private AppSessionManager appSessionManager;
    private Validator validator;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //ButterKnife.bind(this);

        appSessionManager = new AppSessionManager(this);

        validator = new Validator(this);
        validator.setValidationListener(this);

        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);
        buttonLogin = (Button) findViewById(R.id.btn_login);
        linkSignUp = (TextView) findViewById(R.id.link_signup);
        buttonLogin.setOnClickListener(this);
        linkSignUp.setOnClickListener(this);

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
            case R.id.link_signup:
                //startActivity(new Intent(this, RegisterActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void onValidationSucceeded() {
        Map<String, String> params = new HashMap<>();
        params.put(AppSessionManager.KEY_EMAIL, inputEmail.getText().toString());
        params.put(AppSessionManager.KEY_PASSWORD, inputPassword.getText().toString());

        Log.i("trace", params.toString());
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
                            appSessionManager.setEmailUser(params.get(AppSessionManager.KEY_EMAIL));
                            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
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
}
