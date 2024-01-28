package com.santoshbhatt.instapaw.domain.usecase.register

import com.santoshbhatt.instapaw.domain.repository.register.RegisterUserRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(val registerUserRepository: RegisterUserRepository) {
}