package com.santoshbhatt.instapaw.domain.repository.register

import com.santoshbhatt.instapaw.core.common.Resource
import com.santoshbhatt.instapaw.domain.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface RegisterUserRepository {
    fun registerUserWithEmail(userProfile: UserProfile): Flow<Resource<UserProfile>>

}