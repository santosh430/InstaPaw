package com.santoshbhatt.instapaw.data.repository.register

import com.google.firebase.auth.FirebaseAuth
import com.santoshbhatt.instapaw.data.local.AppDatabase
import com.santoshbhatt.instapaw.domain.repository.register.RegisterUserRepository
import javax.inject.Inject

class RegisterUserRepositoryImpl @Inject constructor(
    val firebaseAuth: FirebaseAuth,
    val appDatabase: AppDatabase
):RegisterUserRepository {
    override fun registerUser(userName: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun sendVerificationEmail() {
        TODO("Not yet implemented")
    }
}