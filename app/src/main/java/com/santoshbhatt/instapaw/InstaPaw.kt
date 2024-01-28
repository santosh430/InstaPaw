package com.santoshbhatt.instapaw

import android.app.Application
import com.santoshbhatt.instapaw.core.util.LogType
import com.santoshbhatt.instapaw.core.util.Logcat
import com.santoshbhatt.instapaw.data.repository.login.LoginUserRepositoryImpl
import com.santoshbhatt.instapaw.di.component.DaggerLoginUserComponent
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

            val loginRegisterUserComponent = DaggerLoginUserComponent.builder().build()

        }catch (exception:Exception){
            Logcat.printLog(TAG, LogType.Error,"onCreate(): ",exception)
        }
    }
}