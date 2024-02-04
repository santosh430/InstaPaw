package com.santoshbhatt.instapaw.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserProfile(
    @PrimaryKey
    val userId: Long,
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
