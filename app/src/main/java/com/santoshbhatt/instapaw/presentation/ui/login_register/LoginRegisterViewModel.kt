package com.santoshbhatt.instapaw.presentation.ui.login_register

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.santoshbhatt.instapaw.InstaPaw
import com.santoshbhatt.instapaw.domain.usecase.login_register.LoginRegisterUseCase

class LoginRegisterViewModel(loginRegisterUseCase: LoginRegisterUseCase?, savedStateHandle: SavedStateHandle) :ViewModel() {

    companion object {

        val LoginRegisterViewModelFactory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()
                return LoginRegisterViewModel(
                    (application as InstaPaw).loginRegisterUseCase,
                    savedStateHandle
                ) as T
            }
        }
    }
}