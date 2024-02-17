package com.santoshbhatt.instapaw.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.santoshbhatt.instapaw.R
import com.santoshbhatt.instapaw.data.local.AppDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(appModule: AppModule):AppDatabase{
        return Room.databaseBuilder(
            appModule.providesApplicationContext(),
            AppDatabase::class.java,
            appModule.providesApplicationContext().
            getString(R.string.app_database_name) +
            ".db"
        ).build()
}
}