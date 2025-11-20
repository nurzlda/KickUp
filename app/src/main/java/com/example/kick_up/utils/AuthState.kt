package com.example.kick_up.utils

import com.example.kick_up.data.model.UserDto
import com.example.kick_up.data.model.UserResponse

sealed  class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success(val user: UserResponse) : AuthState()
    data class Error(val message: String) : AuthState()
}