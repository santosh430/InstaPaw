package com.santoshbhatt.instapaw.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.santoshbhatt.instapaw.data.local.dao.UserProfileDao
import com.santoshbhatt.instapaw.data.local.entity.UserProfile

@Database(
    version = 1,
    exportSchema = true,
    entities = [UserProfile::class])
abstract class AppDatabase : RoomDatabase() {

    abstract val userProfileDao:UserProfileDao

}