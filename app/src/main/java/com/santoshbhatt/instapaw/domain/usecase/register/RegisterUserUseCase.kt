package com.santoshbhatt.instapaw.domain.usecase.register

import com.santoshbhatt.instapaw.core.common.Resource
import com.santoshbhatt.instapaw.domain.model.RegisterUserDomain
import com.santoshbhatt.instapaw.domain.repository.register.RegisterUserRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(private val registerUserRepository: RegisterUserRepository) {
 fun registerUserWithEmail(email:String,password:String) =
  registerUserRepository.registerUserWithEmail(email,password)
}