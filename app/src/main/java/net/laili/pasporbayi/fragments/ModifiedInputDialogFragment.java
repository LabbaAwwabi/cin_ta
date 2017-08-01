package net.laili.pasporbayi.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.laili.pasporbayi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ModifiedInputDialogFragment extends DialogFragment {

    @BindView(R.id.edit_modified)
    EditText editText;
    @BindView(R.id.text_modifer)
    TextView textView;
    @BindView(R.id.btn_input)
    Button button;

    private OnFragmentListener listener;

    public ModifiedInputDialogFragment() {
        // Required empty public constructor
    }

    public static ModifiedInputDialogFragment newInstance(String title, String modifier, OnFragmentListener listener) {
        ModifiedInputDialogFragment frag = new ModifiedInputDialogFragment();
        frag.listener = listener;
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("modifier", modifier);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modified_input_dialog, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
        final String modifier = getArguments().getString("modifier", "");

        textView.setText(modifier);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText() != null) {
                    listener.onClikInputButton(editText.getText().toString() + " " + modifier);
                }
            }
        });

        // Show soft keyboard automatically and request focus to field
        editText.requestFocus();

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    public interface OnFragmentListener {
        // TODO: Update argument type and name
        void onClikInputButton(String modifedText);
    }
}
