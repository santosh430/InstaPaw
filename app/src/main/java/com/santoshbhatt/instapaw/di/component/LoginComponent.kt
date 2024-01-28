package com.santoshbhatt.instapaw.di.component

import com.santoshbhatt.instapaw.presentation.ui.login_register.LoginRegisterActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface LoginComponent {
    fun inject(loginRegisterActivity: LoginRegisterActivity)
}