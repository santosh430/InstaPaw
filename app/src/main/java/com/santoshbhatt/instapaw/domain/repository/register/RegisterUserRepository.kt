package com.santoshbhatt.instapaw.domain.repository.register

interface RegisterUserRepository {
    fun registerUser(userName:String,password:String)
    fun sendVerificationEmail()

}