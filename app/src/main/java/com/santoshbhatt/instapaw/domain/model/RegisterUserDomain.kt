package com.santoshbhatt.instapaw.domain.model

data class RegisterUserDomain(
    val username: String,
    val fullName: String,
    val profilePicUrl: String,
    val about: String?,
    val isVerified: Boolean,
    val followers: Long,
    val following: Long,
    val email: String,
    val posts: Int
)
