package com.santoshbhatt.instapaw

import android.app.Application
import com.santoshbhatt.instapaw.core.util.LogType
import com.santoshbhatt.instapaw.core.util.Logcat
import com.santoshbhatt.instapaw.data.repository.login.LoginUserRepositoryImpl
import com.santoshbhatt.instapaw.di.component.DaggerApplicationComponent
import com.santoshbhatt.instapaw.di.component.DaggerLoginRegisterUserComponent
import com.santoshbhatt.instapaw.di.module.AppModule
import com.santoshbhatt.instapaw.domain.repository.login.LoginUserRepository
import com.santoshbhatt.instapaw.domain.usecase.login.LoginUserUseCase
import java.lang.Exception

class InstaPaw: Application() {
    private val TAG = "InstaPaw"
    lateinit var loginUserUseCase:LoginUserUseCase
    override fun onCreate() {
        super.onCreate()
        try {
            val loginUserRepository:LoginUserRepository = LoginUserRepositoryImpl()
            loginUserUseCase = LoginUserUseCase(loginUserRepository)

            val loginRegisterUserComponent = DaggerLoginRegisterUserComponent.builder().build()
            val appComponent = DaggerApplicationComponent.builder().appModule(AppModule(this)).build()

            Logcat.printLog(TAG,LogType.Debug,"appdatabase: ${appComponent.provideLocalDbInstance()}")

        }catch (exception:Exception){
            Logcat.printLog(TAG, LogType.Error,"onCreate(): ",exception)
        }
    }
}