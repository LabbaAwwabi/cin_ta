package net.laili.pasporbayi.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import net.laili.pasporbayi.R;
import net.laili.pasporbayi.activities.DataAnakActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataBalitaFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.wrapper_data_anak)
    RelativeLayout vDataAnak;
    @BindView(R.id.wrapper_riwayat_kelahiran)
    RelativeLayout vRiwayatKelahiran;
    @BindView(R.id.wrapper_riwayat_kesehatan_bayi)
    RelativeLayout vRiwayatKesehatanBayi;
    @BindView(R.id.wrapper_riwayat_medik_penting)
    RelativeLayout vRiwayatMedik;

    public DataBalitaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_balita, container, false);
        ButterKnife.bind(this, view);

        vDataAnak.setOnClickListener(this);
        vRiwayatKelahiran.setOnClickListener(this);
        vRiwayatKesehatanBayi.setOnClickListener(this);
        vRiwayatMedik.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

        switch (viewId) {
            case R.id.wrapper_data_anak :
                startActivity(new Intent(getActivity(), DataAnakActivity.class));
                break;
            case R.id.wrapper_riwayat_kelahiran:
                break;
            case R.id.wrapper_riwayat_kesehatan_bayi:
                break;
            case R.id.wrapper_riwayat_medik_penting:
                break;
        }
    }

}
