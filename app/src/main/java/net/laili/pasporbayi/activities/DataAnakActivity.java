package net.laili.pasporbayi.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;

import net.laili.pasporbayi.R;
import net.laili.pasporbayi.fragments.ModifiedInputDialogFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataAnakActivity extends AppCompatActivity implements View.OnClickListener, Validator.ValidationListener, ModifiedInputDialogFragment.OnFragmentListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

//    @BindView(R.id.input_)
//    EditText input;

    @BindView(R.id.input_nama)
    EditText inputNama;
    @BindView(R.id.input_tanggal_lahir)
    EditText inputTglLahir;
    @BindView(R.id.input_waktu)
    EditText inputWaktu;
    @BindView(R.id.input_berat)
    EditText inputBerat;
    @BindView(R.id.input_panjang)
    EditText inputPanjang;
    @BindView(R.id.input_lingkar_kepala)
    EditText inputLingkarKepala;
    @BindView(R.id.input_tempat_lahir)
    EditText inputTempatLahir;
    @BindView(R.id.input_rumah_sakit)
    EditText inputRumahSakit;

    private static int curRequestDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_anak);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputBerat.setOnClickListener(this);
        inputPanjang.setOnClickListener(this);
        inputLingkarKepala.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

        switch (viewId) {
            case R.id.input_berat :
                curRequestDialog = R.id.input_berat;
                showInputDialog("Berat Badan", "gram");
                break;
            case R.id.input_panjang :

                break;
            case R.id.input_lingkar_kepala :

                break;
        }
    }

    @Override
    public void onValidationSucceeded() {

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

    }

    private void showInputDialog(String tittle, String modifier) {
        FragmentManager fm = getSupportFragmentManager();
        ModifiedInputDialogFragment modifiedInputDialogFragment = ModifiedInputDialogFragment.newInstance(tittle, modifier, this);
        modifiedInputDialogFragment.setCancelable(true);
        modifiedInputDialogFragment.show(fm, tittle);
    }

    /**
     * method dipanggil ketika dialog input modifier disubmit
     * @param modifedText
     */
    @Override
    public void onClikInputButton(String modifedText) {
        switch (curRequestDialog) {
            case R.id.input_berat :
                inputBerat.setText(modifedText);
                break;
            case R.id.input_panjang :

                break;
            case R.id.input_lingkar_kepala :

                break;
        }
    }
}
