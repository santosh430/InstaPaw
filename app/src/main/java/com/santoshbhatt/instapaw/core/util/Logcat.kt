package com.santoshbhatt.instapaw.core.util

import android.util.Log

//Created by Santosh Bhatt on 5 Nov 2023
object Logcat {
    private val TAG = "InstaPaw: "

    fun printLog(tag:String,type:LogType,message: String,exception: Exception? = null){
        when(type){
            LogType.Verbose -> Log.v("$TAG $tag",message)
            LogType.Info ->Log.i("$TAG $tag",message)
            LogType.Error -> {
                exception?.let {
                    Log.e("$TAG $tag","$message : $exception")
                }
            }
            LogType.Debug -> Log.d("$TAG $tag",message)
            LogType.Warn -> Log.w("$TAG $tag",message)
            LogType.Assert -> Log.wtf("$TAG $tag",message)
        }
    }
}

enum class LogType{
    Verbose, Info, Error, Debug, Warn, Assert
}