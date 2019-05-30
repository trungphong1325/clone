package com.treeforcom.clone.di.module;

import android.app.Application;

import androidx.room.Room;

import com.treeforcom.clone.cache.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CacheModule {
    @Provides
    @Singleton
    AppDatabase providerDatabase(Application application){
        return Room.databaseBuilder(application, AppDatabase.class,"database.db").allowMainThreadQueries().build();
    }
}
