package com.santoshbhatt.instapaw

import android.app.Application
import com.santoshbhatt.instapaw.core.util.LogType
import com.santoshbhatt.instapaw.core.util.Logcat
import com.santoshbhatt.instapaw.data.repository.login_register.LoginRegisterRegisterRepositoryImpl
import com.santoshbhatt.instapaw.domain.repository.login_register.LoginRegisterRepository
import com.santoshbhatt.instapaw.domain.usecase.login_register.LoginRegisterUseCase
import java.lang.Exception

class InstaPaw: Application() {
    private val TAG = "InstaPaw"
    lateinit var loginRegisterUseCase:LoginRegisterUseCase
    override fun onCreate() {
        super.onCreate()
        try {
            val loginRegisterRepository:LoginRegisterRepository = LoginRegisterRegisterRepositoryImpl()
            loginRegisterUseCase = LoginRegisterUseCase(loginRegisterRepository)
        }catch (exception:Exception){
            Logcat.printLog(TAG, LogType.Error,"onCreate(): ",exception)
        }
    }
}