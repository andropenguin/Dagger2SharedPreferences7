package com.sarltokyo.dagger2sharedpreferences7.module;

import android.content.Context;
import android.content.SharedPreferences;
import com.sarltokyo.dagger2sharedpreferences7.App;
import com.sarltokyo.dagger2sharedpreferences7.app.MyFragment;
import com.sarltokyo.dagger2sharedpreferences7.preference.Settings;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by osabe on 15/08/22.
 */
@Module
public class SharedPrefsModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs() {
        return App.getInstance()
                .getSharedPreferences(Settings.CONFIG_MAME, Context.MODE_PRIVATE);
    }
}
