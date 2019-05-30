package com.treeforcom.clone.di.component;


import android.app.Application;

import com.treeforcom.clone.MainApplication;
import com.treeforcom.clone.di.module.ActivityModule;
import com.treeforcom.clone.di.module.CacheModule;
import com.treeforcom.clone.di.module.NetworkModule;
import com.treeforcom.clone.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {NetworkModule.class,
        CacheModule.class,
        ViewModelModule.class, ActivityModule.class,
        AndroidSupportInjectionModule.class})

@Singleton
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(MainApplication mainApplication);
}
