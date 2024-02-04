package com.santoshbhatt.instapaw.di.module

import android.content.Context
import com.santoshbhatt.instapaw.InstaPaw
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule @Inject constructor(private val application: InstaPaw) {

    @Provides
    @Singleton
    fun providesApplication(): InstaPaw = application

    @Provides
    @Singleton
    fun providesApplicationContext(): Context = application

}