package com.santoshbhatt.instapaw.domain.model

data class UserProfile(
    val isVerified: Boolean = false,
    val email: String,
    val password:String,
    val profile: Profile,
    val mobileNumber:Int,
    val dateOfBirth:Long,
    val settings: Settings,
    val notifications:List<Notification>? = null,
    val pets:List<Pet>? = null,
    val rescueProfile:RescueProfile
)
