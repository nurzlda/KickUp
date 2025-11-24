package com.example.kick_up.ui.fragments.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kick_up.data.model.UserResponse
import com.example.kick_up.data.repo.UserRepository
import com.example.kick_up.utils.AuthState
import com.example.kick_up.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val repository: UserRepository): ViewModel(){
    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState

    fun login(email: String, password: String){
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            try {
                // Используем Model (Repository) для получения данных
                val user = repository.login(email, password)
                _authState.value = AuthState.Success(user)
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: "Unknown error")
            }
        }
    }
}