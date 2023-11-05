package com.santoshbhatt.instapaw

import android.app.Application
import com.santoshbhatt.instapaw.core.util.LogType
import com.santoshbhatt.instapaw.core.util.Logcat

class InstaPaw: Application() {
    private val TAG = "InstaPaw"
    override fun onCreate() {
        super.onCreate()
        try {

        }catch (exception:Exception){
            Logcat.printLog(TAG, LogType.Error,"onCreate(): ",exception)
        }
    }
}