package com.santoshbhatt.instapaw.presentation.ui.login_register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.santoshbhatt.instapaw.R
import com.santoshbhatt.instapaw.core.util.LogType
import com.santoshbhatt.instapaw.core.util.Logcat
import com.santoshbhatt.instapaw.databinding.ActivityLoginRegisterBinding

class LoginRegisterActivity : AppCompatActivity() {
    private val TAG = "LoginRegisterActivity"
    private lateinit var binding: ActivityLoginRegisterBinding
    private val loginViewModel by viewModels<LoginRegisterViewModel> { LoginRegisterViewModel.LoginRegisterViewModelFactory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
            setContentView(binding.root)
            supportActionBar?.hide()

            Logcat.printLog(TAG,LogType.Debug,"viewmodel: $loginViewModel")

        }catch (exception:Exception){
            Logcat.printLog(TAG,LogType.Error,"onCreate(): ",exception)
        }
    }
}