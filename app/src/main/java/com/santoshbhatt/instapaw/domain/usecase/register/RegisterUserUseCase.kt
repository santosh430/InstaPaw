package com.santoshbhatt.instapaw.domain.usecase.register

import com.santoshbhatt.instapaw.domain.model.UserProfile
import com.santoshbhatt.instapaw.domain.repository.register.RegisterUserRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(private val registerUserRepository: RegisterUserRepository) {
 fun registerUserWithEmail(user: UserProfile) =
  registerUserRepository.registerUserWithEmail(user)
}