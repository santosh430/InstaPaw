package com.santoshbhatt.instapaw.di.component

import com.santoshbhatt.instapaw.data.local.AppDatabase
import com.santoshbhatt.instapaw.di.module.AppModule
import com.santoshbhatt.instapaw.di.module.DatabaseModule
import com.santoshbhatt.instapaw.presentation.ui.login_register.LoginRegisterActivity
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,DatabaseModule::class])
interface ApplicationComponent {
    fun inject(loginRegisterActivity: LoginRegisterActivity)

    fun provideLocalDbInstance():AppDatabase
}