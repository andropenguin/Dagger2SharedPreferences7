package com.sarltokyo.dagger2sharedpreferences7.component;

import com.sarltokyo.dagger2sharedpreferences7.InjectedBaseActivityTest;
import com.sarltokyo.dagger2sharedpreferences7.module.DebugSharedPrefsModule;
import com.sarltokyo.dagger2sharedpreferences7.preference.Settings;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by osabe on 15/08/22.
 */
@Singleton
@Component(modules = {DebugSharedPrefsModule.class})
public interface SharedPrefsComponent {
    void inject(Settings settings);
    void inject(InjectedBaseActivityTest test);

    public final static class Initializer {
        public static SharedPrefsComponent init(boolean mockMode) {
            return DaggerSharedPrefsComponent.builder()
                    .debugSharedPrefsModule(new DebugSharedPrefsModule(mockMode))
                    .build();
        }
    }
}
