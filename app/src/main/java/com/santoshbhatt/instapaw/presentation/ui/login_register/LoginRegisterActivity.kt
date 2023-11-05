package com.santoshbhatt.instapaw.presentation.ui.login_register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.santoshbhatt.instapaw.R
import com.santoshbhatt.instapaw.core.util.LogType
import com.santoshbhatt.instapaw.core.util.Logcat

class LoginRegisterActivity : AppCompatActivity() {
    private val TAG = "LoginRegisterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)
        try {
            supportActionBar?.hide()
        }catch (exception:Exception){
            Logcat.printLog(TAG,LogType.Error,"onCreate(): ",exception)
        }
    }
}