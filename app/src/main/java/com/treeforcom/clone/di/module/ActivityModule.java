package com.treeforcom.clone.di.module;

import com.treeforcom.clone.view.login.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector()
    abstract LoginActivity contributeLoginActivity();
}
