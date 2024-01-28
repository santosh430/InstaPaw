package com.santoshbhatt.instapaw.di.component

import com.santoshbhatt.instapaw.di.module.LoginUserModule
import com.santoshbhatt.instapaw.presentation.ui.login_register.LoginRegisterActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = arrayOf(LoginUserModule::class))
interface LoginUserComponent {
    fun injectLoginRegisterActivity(loginRegisterActivity: LoginRegisterActivity)
}