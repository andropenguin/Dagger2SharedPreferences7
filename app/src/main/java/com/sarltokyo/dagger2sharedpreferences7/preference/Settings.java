package com.sarltokyo.dagger2sharedpreferences7.preference;

import android.content.Context;
import android.content.SharedPreferences;
import com.sarltokyo.dagger2sharedpreferences7.App;

import javax.inject.Inject;

/**
 * Created by osabe on 15/08/22.
 */
public class Settings {
    private final static String TAG = Settings.class.getSimpleName();

    private static Settings INSTANCE = null;

    @Inject
    public SharedPreferences mPreference;

    public final static String CONFIG_MAME = "appconfig";
    public final static String KEY_TEXT = "text";

    private Settings(Context context) {
//        mPreference = context.getSharedPreferences(CONFIG_MAME, Context.MODE_PRIVATE);
        App.getInstance().component().inject(this);

    }

    public static Settings getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Settings(context);
        }
        return INSTANCE;
    }

    public String getPrefText() {
//        return mPreference.getString(KEY_TEXT, "");
        return getPreference().getString(KEY_TEXT, "");
    }

    public void setPrefText(String text) {
//        mPreference.edit().putString(KEY_TEXT, text).commit();
        getPreference().edit().putString(KEY_TEXT, text).commit();
    }

    protected SharedPreferences getPreference() {
        return mPreference;
    }
}
