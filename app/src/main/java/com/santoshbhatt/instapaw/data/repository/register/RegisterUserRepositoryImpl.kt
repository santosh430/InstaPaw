package com.santoshbhatt.instapaw.data.repository.register

import android.os.CountDownTimer
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.santoshbhatt.instapaw.R
import com.santoshbhatt.instapaw.core.common.Resource
import com.santoshbhatt.instapaw.core.util.LogType
import com.santoshbhatt.instapaw.core.util.Logcat
import com.santoshbhatt.instapaw.data.local.AppDatabase
import com.santoshbhatt.instapaw.di.module.AppModule
import com.santoshbhatt.instapaw.domain.model.RegisterUserDomain
import com.santoshbhatt.instapaw.domain.repository.register.RegisterUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

const val TAG = "RegisterUserRepositoryImpl"
class RegisterUserRepositoryImpl @Inject constructor(
    val firebaseAuth: FirebaseAuth,
    val appDatabase: AppDatabase,
    val appModule: AppModule
):RegisterUserRepository {
    override fun registerUserWithEmail(email: String, password: String) = flow<Resource<RegisterUserDomain>> {
        try {
            emit(Resource.Loading())
            firebaseAuth.createUserWithEmailAndPassword(
                email,
                password
            ).addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        // Sign in success
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = firebaseAuth.currentUser
                        if (user != null){
                            sendVerificationEmail(user)
                        }else{
                            //show error message in UI
                        }

                    } else {
                        Log.e(TAG, "createUserWithEmail:failure", task.exception)
                    }
                }
        }catch (exception:Exception){
            Logcat.printLog(TAG, LogType.Error,"registerNewUser(): ",exception)
        }
    }.flowOn(Dispatchers.IO)
        .catch {
            Logcat.printLog(TAG, LogType.Error,"registerNewUser(): ",it as java.lang.Exception)
        emit(Resource.Error(appModule.providesApplicationContext().getString(R.string.fail_process_fetcing)))
    }

    private fun sendVerificationEmail(user: FirebaseUser) {
        try {
            user.sendEmailVerification().addOnCompleteListener{
                if (it.isSuccessful){
                    //email is sent to the user email address, Update UI to notify user to check their inbox.
                    startTimerToCheckEmailVerification(user)
                }
            }
        }catch (exception:Exception){
            Logcat.printLog(TAG,LogType.Error,"sendVerificationEmail(): ",exception)
        }
    }

    private fun startTimerToCheckEmailVerification(user: FirebaseUser) {
        try {
            val duration:Long = 300000
            object : CountDownTimer(duration,1000){
                override fun onTick(p0: Long) {
                    if (user.isEmailVerified){
                        //Cancel the timer and Onboard User and Navigate to the Home Screen.
                        cancel()
                    }
                }

                override fun onFinish() {
                    //Navigate to Login Screen
                }

            }.start()
        }catch (exception:Exception){
            Logcat.printLog(TAG,LogType.Error,"sendVerificationEmail(): ",exception)
        }
    }
}