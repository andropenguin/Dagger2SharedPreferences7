package com.sarltokyo.dagger2sharedpreferences7.module;

import android.content.Context;
import android.content.SharedPreferences;
import com.sarltokyo.dagger2sharedpreferences7.App;
import com.sarltokyo.dagger2sharedpreferences7.preference.Settings;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by osabe on 15/08/22.
 */
@Module
public class DebugSharedPrefsModule {
    private final boolean mockMode;

    // テスト用
    public final static String CONFIG_MAME = "test_" + Settings.CONFIG_MAME;

    public DebugSharedPrefsModule(boolean provideMocks) {
        mockMode = provideMocks;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs() {
        if (mockMode) {
//            return mock(SharedPreferences.class);
            // mockではなく、テスト用プリファレンスファイルを使用
            return App.getInstance()
                    .getSharedPreferences(CONFIG_MAME, Context.MODE_PRIVATE);
        } else {
            return App.getInstance()
                    .getSharedPreferences(Settings.CONFIG_MAME, Context.MODE_PRIVATE);
        }
    }
}
