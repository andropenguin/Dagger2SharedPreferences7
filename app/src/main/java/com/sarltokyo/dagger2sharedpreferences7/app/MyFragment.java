package com.sarltokyo.dagger2sharedpreferences7.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.sarltokyo.dagger2sharedpreferences7.preference.Settings;

/**
 * Created by osabe on 15/08/21.
 */
public class MyFragment extends Fragment implements View.OnClickListener {
    private final static String TAG = MyFragment.class.getSimpleName();

    private EditText mPrefEt;
    private Button mBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mPrefEt = (EditText)view.findViewById(R.id.prefEt);
        mBtn = (Button)view.findViewById(R.id.btn);
        mBtn.setOnClickListener(this);

        loadConfig();

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn) {
            String text = mPrefEt.getText().toString();
            if (TextUtils.isEmpty(text)) return;;
            saveText(text);
        }
    }

    private void loadConfig() {
        mPrefEt.setText(Settings.getInstance(getActivity()).getPrefText());
    }

    private void saveText(String text) {
        Settings.getInstance(getActivity()).setPrefText(text);
    }
}
