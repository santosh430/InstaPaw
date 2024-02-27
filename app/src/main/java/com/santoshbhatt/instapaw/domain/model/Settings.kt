package com.santoshbhatt.instapaw.domain.model

data class Settings(
    val selectedLanguage:String,
    val isNotificationEnabled:Boolean,
    val appearance:Appearance
)
