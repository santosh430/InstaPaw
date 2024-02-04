package com.santoshbhatt.instapaw.data.local.dao

import androidx.room.Dao
import androidx.room.Upsert
import com.santoshbhatt.instapaw.data.local.entity.UserProfile

@Dao
interface UserProfileDao {

    @Upsert
    suspend fun insertOrUpdateUserProfile(userProfile: UserProfile)
}