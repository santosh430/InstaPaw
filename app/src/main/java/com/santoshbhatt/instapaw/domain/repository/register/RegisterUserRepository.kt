package com.santoshbhatt.instapaw.domain.repository.register

import com.santoshbhatt.instapaw.core.common.Resource
import com.santoshbhatt.instapaw.domain.model.RegisterUserDomain
import kotlinx.coroutines.flow.Flow

interface RegisterUserRepository {
    fun registerUserWithEmail(email:String, password:String): Flow<Resource<RegisterUserDomain>>

}