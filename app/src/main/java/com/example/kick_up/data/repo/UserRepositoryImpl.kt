package com.example.kick_up.data.repo

import com.example.kick_up.data.api.ApiService
import com.example.kick_up.data.model.LoginDto
import com.example.kick_up.data.model.UserDto
import com.example.kick_up.data.model.UserResponse
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: ApiService): UserRepository {
    override suspend fun register(
        email: String,
        password: String,
        name: String
    ): UserResponse {
        return apiService.register(UserDto(email = email,password=password,name=name))
    }

    override suspend fun login(
        email: String,
        password: String
    ): UserResponse {
        return apiService.login(LoginDto(email = email, password = password))
    }
}